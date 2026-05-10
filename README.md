# Makarand P. Thorat - Personal Website (Spring Boot + Angular)

A professional, clean, and responsive personal portfolio website showcasing experience, projects, and skills. This project features a Spring Boot REST API backend and a modular Angular SPA frontend styled with Tailwind CSS 3.

## Deployment (Google Cloud Platform)

This site is fully automated for deployment on GCP within the **Always Free** tier using:
*   **Cloud Run** (Backend API)
*   **Firebase Hosting** (Angular Frontend)
*   **Cloud Build** (CI/CD Pipeline)
*   **Terraform** (Infrastructure as Code)

For detailed deployment and maintenance instructions, see [GEMINI.md](./GEMINI.md) or the [infra/README.md](./infra/README.md).

## Project Structure

```text
personal-website/
├── backend/                # Spring Boot REST API
│   ├── src/main/java/      # Java Source Code
│   └── pom.xml             # Maven Configuration
├── frontend/               # Angular SPA
│   ├── src/app/            # Angular Components (Sidebar, Resume, CoverLetter)
│   ├── src/styles.css      # Global Styles (Tailwind CSS 3)
│   ├── tailwind.config.js  # Tailwind CSS Configuration
│   └── package.json        # Node.js Dependencies
├── README.md               # Getting Started Guide
├── GEMINI.md               # Project Context & Architecture
├── resources/              # Static resources like Resume PDFs
└── .gitignore              # Git Exclusions
```

## Prerequisites

- **Java 17** or higher
- **Node.js (v18+)** and **npm**
- **Angular CLI** (`npm install -g @angular/cli`)

## Getting Started

### 1. Run the Backend (Spring Boot)
The backend provides the data for the portfolio through REST endpoints.
```bash
cd backend
mvn spring-boot:run
```
- **API URL:** `http://localhost:8080/api`
- **Data Source:** Currently config-driven via `DataService.java`.

### 2. Run the Frontend (Angular)
The frontend is a single-page application that consumes the backend API.
```bash
cd frontend
npm install
ng serve
- **API URL:** `http://localhost:8080/api`
- **Data Source:** Config-driven via `backend/src/main/resources/resume-data.json`. No code changes required to update content.

### 2. Run the Frontend (Angular)
...
- **JSON-Driven Architecture:** The entire portfolio content is managed via a single `resume-data.json` file in the backend, separating content from code.
- **Dynamic Skill Categorization:** Skills are grouped by categories (Programming, Web, Database, etc.) for better readability.
- **Professional Timeline:** A visual vertical timeline representing over 15 years of career progression.
- **Certification & Awards Tracking:** Dedicated sections for professional certifications (with verification links) and industry recognition.
...
- **API Endpoints**

- `GET /api/profile` - Basic identity information.
- `GET /api/about` - Summary and high-level technical skills.
- `GET /api/experience` - Full career timeline (Senior Architect to Associate).
- `GET /api/projects` - Key project portfolio.
- `GET /api/certifications` - Professional credentials with verification links.
- `GET /api/awards` - Honors and recognition (CheerBoard nominations).
- `GET /api/skill-categories` - Grouped technical expertise.
- `GET /api/hobbies` - Personal interests.
- `GET /api/contact` - Communication links.
- `GET /api/cover-letter` - Cover letter content.

