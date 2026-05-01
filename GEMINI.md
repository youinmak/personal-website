# Project Context: personal-website

A professional, clean, and responsive personal portfolio website built with a Spring Boot backend and an Angular frontend, showcasing Makarand P. Thorat's resume and cover letter.

## Project Overview
- **Backend:** Spring Boot 3.2.4 (Java 17, Maven)
- **Frontend:** Angular 19 (SPA) with Tailwind CSS 3
- **Architecture:** 
  - Backend: Controller -> Service -> DTO (Config-driven via `DataService.java`)
  - Frontend: Modular, component-based SPA (`SidebarComponent`, `ResumeComponent`, `CoverLetterComponent`).

## Building and Running

### Backend
- **Run:** `cd backend && mvn spring-boot:run`
- **Build:** `cd backend && mvn clean install`
- **API Base URL:** `http://localhost:8080/api`

### Frontend
- **Install Dependencies:** `cd frontend && npm install`
- **Run:** `cd frontend && ng serve`
- **Build:** `cd frontend && ng build`
- **URL:** `http://localhost:4200`

## Development Conventions
- **Backend:** 
  - Use Java 17 records for DTOs.
  - Controllers should be cross-origin enabled for development (`localhost:4200`).
  - Layered architecture (Controller -> Service -> DTO).
- **Frontend:**
  - Standalone components (Angular 19 default).
  - Tailwind CSS 3 for styling (configured in `tailwind.config.js`, imported in `styles.css`).
  - **Smart Components:** Components inject `ApiService` directly to fetch the specific data they need, rather than relying on `@Input` passing from the root component.
  - Support for dark/light mode via Tailwind's `dark:` classes and a root `[class.dark]` toggle.
  - **Loading States:** Use the reusable `LoadingSkeletonComponent` with `ng-template` to show shimmering placeholders while `Observable` data streams are pending.
  - **PDF Generation:** Use `html2canvas` and `jspdf` to convert the `pdf-container` into a downloadable A4-sized PDF, respecting dark/light mode backgrounds.

## Project Structure
- `/backend`: Contains Java source code and Maven configuration.
- `/frontend`: Contains Angular source code, Tailwind configuration, and npm scripts.
- `README.md`: High-level instructions for setup, features, and execution.
- `resources/`: Location for raw assets, such as the source PDF resume.