# --- 1. Project Services (APIs) ---
# Enable the necessary GCP services for this project
resource "google_project_service" "services" {
  for_each = toset([
    "run.googleapis.com",              # Cloud Run for Backend
    "artifactregistry.googleapis.com", # Artifact Registry for Docker Images
    "cloudbuild.googleapis.com",       # Cloud Build for CI/CD
    "firebase.googleapis.com",         # Firebase for Frontend Hosting
    "iam.googleapis.com"               # Identity & Access Management
  ])
  service = each.key
  disable_on_destroy = false
}

# --- 2. Artifact Registry ---
# Repository to store our backend Docker images
resource "google_artifact_registry_repository" "repo" {
  location      = var.region
  repository_id = var.repository_id
  description   = "Docker repository for personal website"
  format        = "DOCKER"
  
  # Automated cleanup to stay within the 0.5 GB Always Free tier limit
  cleanup_policies {
    id     = "keep-minimum-versions"
    action = "KEEP"
    most_recent_versions {
      keep_count = 3
    }
  }

  cleanup_policies {
    id     = "delete-old-versions"
    action = "DELETE"
    condition {
      older_than = "2592000s" # Delete images older than 30 days
    }
  }

  depends_on = [google_project_service.services]
}

# --- 3. Cloud Run (Backend Service) ---
# Serverless platform for the Spring Boot application
resource "google_cloud_run_v2_service" "backend" {
  name     = var.service_name
  location = var.region
  ingress  = "INGRESS_TRAFFIC_ALL" # Allow public access

  template {
    # Force the use of the default Compute Service Account to clear stale identity references
    service_account = "${data.google_project.project.number}-compute@developer.gserviceaccount.com"

    containers {
      # Placeholder image for initial creation. 
      # Replaced by Cloud Build with the actual app during deployment.
      image = "gcr.io/cloudrun/hello" 
      ports {
        container_port = 8080
      }
      resources {
        limits = {
          cpu    = "1"
          memory = "512Mi" # Baseline requirement for Spring Boot
        }
      }
      env {
        name  = "CORS_ALLOWED_ORIGINS"
        value = "http://localhost:4200,https://${var.project_id}.web.app,https://${var.project_id}.firebaseapp.com"
      }
      env {
        name  = "SPRING_PROFILES_ACTIVE"
        value = "prod"
      }
    }
    
    # Efficient scaling for Free Tier: Scale to zero when idle
    scaling {
      min_instance_count = 0
      max_instance_count = 1
    }
  }

  # Use the latest Cloud Run generation (Gen2)
  launch_stage = "GA"

  depends_on = [google_project_service.services]
}

# Allow "allUsers" (unauthenticated) to invoke the Cloud Run service
resource "google_cloud_run_v2_service_iam_member" "noauth" {
  location = google_cloud_run_v2_service.backend.location
  name     = google_cloud_run_v2_service.backend.name
  role     = "roles/run.invoker"
  member   = "allUsers"
}

# --- 4. Firebase (Frontend Hosting) ---
# Initialize the Firebase project link
resource "google_firebase_project" "default" {
  provider = google-beta
  project  = var.project_id
  depends_on = [google_project_service.services]
}

# Create the Firebase Hosting site
resource "google_firebase_hosting_site" "default" {
  provider = google-beta
  project  = var.project_id
  site_id  = "${var.project_id}-hosting"
  depends_on = [google_firebase_project.default]
}

# --- 5. IAM & Permissions for CI/CD ---
# Retrieve project details (number) to construct service account emails
data "google_project" "project" {}

# Define the service accounts and roles needed for the build pipeline
locals {
  service_accounts = [
    "serviceAccount:${data.google_project.project.number}-compute@developer.gserviceaccount.com",
    "serviceAccount:${data.google_project.project.number}@cloudbuild.gserviceaccount.com"
  ]
  roles = [
    "roles/logging.logWriter",      # For build logs
    "roles/artifactregistry.writer", # To push images
    "roles/run.admin",              # To deploy to Cloud Run
    "roles/iam.serviceAccountUser", # To act as the service account
    "roles/firebase.admin",          # To deploy to Firebase
    "roles/storage.admin"           # To access the build source bucket
  ]
  # Matrix of accounts x roles
  sa_role_pairs = flatten([
    for sa in local.service_accounts : [
      for role in local.roles : {
        sa   = sa
        role = role
      }
    ]
  ])
}

# Apply all IAM bindings
resource "google_project_iam_member" "ci_cd_roles" {
  for_each = { for pair in local.sa_role_pairs : "${pair.sa}-${pair.role}" => pair }
  
  project = var.project_id
  role    = each.value.role
  member  = each.value.sa
}

# --- 6. Outputs ---
output "backend_url" {
  description = "The URL of the deployed Cloud Run backend"
  value       = google_cloud_run_v2_service.backend.uri
}

output "artifact_registry_repo" {
  description = "The Artifact Registry repository URL"
  value       = "${var.region}-docker.pkg.dev/${var.project_id}/${var.repository_id}"
}
