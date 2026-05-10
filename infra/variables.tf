variable "project_id" {
  description = "The unique ID of your Google Cloud Project."
  type        = string

  validation {
    condition     = length(var.project_id) > 0
    error_message = "The project_id variable must not be empty."
  }
}

variable "region" {
  description = "The GCP region to deploy resources in. Use us-central1, us-east1, or us-west1 for Always Free eligibility."
  type        = string
  default     = "us-central1"
}

variable "service_name" {
  description = "The name given to the backend Cloud Run service."
  type        = string
  default     = "personal-website-backend"
}

variable "repository_id" {
  description = "The ID for the Artifact Registry repository."
  type        = string
  default     = "personal-website"
}
