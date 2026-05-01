# Makarand P. Thorat - Personal Website (Spring Boot + Angular)

A professional, clean, and responsive personal portfolio website showcasing experience, projects, and skills. This project features a Spring Boot REST API backend and a modular Angular SPA frontend styled with Tailwind CSS 3.

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
```
- **Website URL:** `http://localhost:4200`

## Features

- **Single Page Application (SPA):** Smooth, unified user experience built with standalone Angular components.
- **Responsive Design:** Mobile-first approach using Tailwind CSS 3.
- **Dark Mode Support:** Seamless switching between light and dark themes.
- **RESTful Integration:** Dynamic content fetching from the Spring Boot backend.
- **Download as PDF:** Generate a high-quality PDF of the active view (Resume or Cover Letter) using `html2canvas` and `jspdf`.
- **Loading Skeletons:** Animated skeleton loaders provide a polished UI while waiting for API responses.
- **Smart Components:** Modular structure with components autonomously fetching their required data.

## API Endpoints

- `GET /api/profile` - Basic identity information.
- `GET /api/about` - Summary and technical skills.
- `GET /api/experience` - Professional timeline.
- `GET /api/projects` - Featured work and portfolio items.
- `GET /api/hobbies` - Personal interests.
- `GET /api/contact` - Communication links.
- `GET /api/cover-letter` - Cover letter content.
