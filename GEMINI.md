# Project Context: personal-website

A minimal, clean, and responsive personal portfolio website built with a Spring Boot backend and an Angular frontend.

## Project Overview
- **Backend:** Spring Boot 3.2.4 (Java 17, Maven)
- **Frontend:** Angular 19 (SPA) with Tailwind CSS 4
- **Architecture:** 
  - Backend: Controller -> Service -> DTO (Config-driven)
  - Frontend: Component-based SPA fetching data via REST services.

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
  - Tailwind CSS 4 for styling (imported in `styles.css`).
  - Use `ApiService` for all backend communication.
  - Support for dark/light mode via Tailwind's `dark:` classes and a root `[class.dark]` toggle.

## Project Structure
- `/backend`: Contains Java source code and Maven configuration.
- `/frontend`: Contains Angular source code, Tailwind configuration, and npm scripts.
- `README.md`: High-level instructions for setup and execution.
