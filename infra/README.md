# Infrastructure as Code (GCP)

This directory contains the Terraform configuration to provision the Google Cloud Platform (GCP) resources required for the personal website.

## Architecture
*   **Backend:** Google Cloud Run (Serverless container).
*   **Frontend:** Firebase Hosting (Static asset hosting).
*   **Image Storage:** Artifact Registry (Docker images).
*   **CI/CD:** Google Cloud Build (Automated build and deploy).

## Files
*   `provider.tf`: Configures the GCP and GCP-Beta providers.
*   `variables.tf`: Defines configurable parameters (Project ID, Region, etc.).
*   `main.tf`: Defines all cloud resources and IAM permissions.
*   `terraform.tfvars.example`: Template for your environment-specific values.

## Prerequisites
1.  **Terraform:** Install the [Terraform CLI](https://developer.hashicorp.com/terraform/downloads).
2.  **GCP Project:** Create a project in the [GCP Console](https://console.cloud.google.com/).
3.  **Authentication:** Run `gcloud auth application-default login` to allow Terraform to act on your behalf.

## Usage
1.  Initialize Terraform:
    ```bash
    terraform init
    ```
2.  Create your `terraform.tfvars` from the example:
    ```bash
    cp terraform.tfvars.example terraform.tfvars
    # Edit terraform.tfvars with your project_id
    ```
3.  Deploy the infrastructure:
    ```bash
    terraform plan
    terraform apply
    ```

## Cleanup
To remove all resources and avoid charges:
```bash
terraform destroy
```
