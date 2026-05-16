# Project Context: personal-website

A professional, clean, and responsive personal portfolio website built with a Spring Boot backend and an Angular frontend, showcasing Makarand P. Thorat's resume and cover letter.

## Project Overview
- **Backend:** Spring Boot 3.2.4 (Java 17, Maven)
- **Frontend:** Angular 19 (SPA) with Tailwind CSS 3
- **Architecture:** 
  - Backend: Controller -> Service -> DTO (Externalized via `resume-data.json`)
  - Frontend: Modular, component-based SPA with dedicated sections for Experience, Skills, Certifications, and Awards.

## GCP Deployment (Free Tier)

This project is configured for deployment to GCP using Cloud Run (Backend) and Firebase Hosting (Frontend).

### Infrastructure Setup (Terraform)
1.  Install Terraform.
2.  `cd infra`
3.  Copy `terraform.tfvars.example` to `terraform.tfvars` and fill in your `project_id`.
4.  Run `terraform init`, `terraform plan`, and `terraform apply`.

### CI/CD (Cloud Build)
A `cloudbuild.yaml` is provided to automate the build and deployment.
1.  Ensure the Cloud Build service account has the following roles:
    - Cloud Run Admin
    - Artifact Registry Administrator
    - Firebase Admin
    - Service Account User
2.  Connect your repository to Cloud Build or run manually:
    `gcloud builds submit --config cloudbuild.yaml --substitutions=_REPOSITORY_ID=your-repo, _SERVICE_NAME=your-service`

### Troubleshooting Common Errors

*   **Permission Denied (Firebase 403):** 
    1.  Confirm you have the `Owner` role on the project.
    2.  Check if the **Firebase Management API** is enabled in the [API Library](https://console.cloud.google.com/apis/library/firebase.googleapis.com).
    3.  If the error persists, you may need to manually click "Add Firebase" in the [Firebase Console](https://console.firebase.google.com/) once to initialize the project, then run Terraform again to manage the hosting site.
*   **Memory Limit Error (Cloud Run):** If you see a memory error, ensure memory is at least `512Mi`. While smaller is possible in some regions/configs, `512Mi` is the safest baseline for Spring Boot.
*   **Connect: No route to host:** This is usually a transient local networking issue or a temporary GCP API outage. Retry the command after a minute.
*   **API Not Enabled:** Terraform attempts to enable APIs, but sometimes it fails if the billing account isn't fully linked. Check the [GCP API Dashboard](https://console.cloud.google.com/apis/dashboard).

The current configuration is designed to stay within the **GCP Always Free** tier:

*   **Cloud Run (Backend):**
    *   *Limit:* 2 million requests/month, 360,000 GB-seconds, 180,000 vCPU-seconds.
    *   *Config:* Scaling is set to `min_instance_count = 0` (scales to zero when idle). Memory is set to `512Mi` (Spring Boot baseline).
    *   *Region:* Use `us-central1`, `us-west1`, or `us-east1` for Always Free eligibility.
*   **Artifact Registry (Docker Images):**
    *   *Limit:* 0.5 GB storage/month.
    *   *Config:* A cleanup policy is applied to keep only the **3 most recent images** and delete images older than 30 days.
*   **Firebase Hosting (Frontend):**
    *   *Limit:* 10 GB storage, 360 MB/day data transfer.
    *   *Config:* Optimized for SPA; standard usage for a personal portfolio will stay well within these limits.
*   **Cloud Build (CI/CD):**
    *   *Limit:* 120 build-minutes per day.
    *   *Config:* Efficient multi-stage Docker builds and cached npm installs.
*   **Cloud Logging:**
    *   *Limit:* First 50 GB per project.

## Security & Hardening

This project follows several security best practices:
*   **Non-Root Container:** The backend Docker image runs as a non-privileged `spring` user.
*   **CORS Restriction:** API access is restricted to the specific frontend domains (`localhost` and your Firebase URLs).
*   **Automated Cleanup:** Artifact Registry automatically purges old images to stay within Free Tier and minimize risk.
*   **Serverless Scaling:** The architecture is designed to scale to zero, reducing the window of exposure for the backend.

### Decommissioning Infrastructure
To remove all GCP resources and avoid any future charges:
1.  `cd infra`
2.  Run `terraform destroy`
3.  **Manual Cleanup:** Terraform may not delete the Docker images stored in Artifact Registry or the logs in Cloud Build. After running destroy, it is recommended to check the [Artifact Registry Console](https://console.cloud.google.com/artifacts) and [Cloud Storage Console](https://console.cloud.google.com/storage) to manually delete any remaining data.
- **Backend:** 
  - Use Java 17 records for DTOs.
  - Data is managed in `src/main/resources/resume-data.json` and loaded via `DataService.java` using Jackson.
  - Controllers are cross-origin enabled for development (`localhost:4200`).
  - Layered architecture (Controller -> Service -> DTO).
- **Frontend:**
  - Standalone components (Angular 19 default).
  - Tailwind CSS 3 for styling (configured in `tailwind.config.js`, imported in `styles.css`).
  - **Data Fetching:** Smart Components use `ApiService` to fetch specific data streams (Experience, SkillCategories, Certifications, etc.).
  - Support for dark/light mode via Tailwind's `dark:` classes and a root `[class.dark]` toggle.
  - **Loading States:** Use the reusable `LoadingSkeletonComponent` with `ng-template` to show shimmering placeholders.
  - **PDF Generation:** Use `html2canvas` and `jspdf` to convert the `pdf-container` into a downloadable A4-sized PDF.

## Project Structure
- `/backend`: Contains Java source code, Maven configuration, and `resume-data.json`.
- `/frontend`: Contains Angular source code, Tailwind configuration, and npm scripts.
- `README.md`: High-level instructions for setup, features, and execution.
- `resources/`: Location for raw assets, such as the source PDF resume.
