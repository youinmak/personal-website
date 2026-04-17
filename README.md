# Personal Website (Spring Boot + Angular)

A minimal, clean, and responsive personal portfolio website. This project features a Spring Boot REST API backend and an Angular SPA frontend with Tailwind CSS 4.

## Project Structure

```text
personal-website/
├── backend/                # Spring Boot REST API
│   ├── src/main/java/      # Java Source Code
│   └── pom.xml             # Maven Configuration
├── frontend/               # Angular SPA
│   ├── src/app/            # Angular Components, Services, Models
│   ├── src/styles.css      # Global Styles (Tailwind CSS 4)
│   └── package.json        # Node.js Dependencies
├── README.md               # Getting Started Guide
├── GEMINI.md               # Project Context & Architecture
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

- **Single Page Application (SPA):** Smooth, unified user experience.
- **Responsive Design:** Mobile-first approach using Tailwind CSS 4.
- **Dark Mode Support:** Seamless switching between light and dark themes.
- **RESTful Integration:** Dynamic content fetching from the backend.
- **Clean UI:** Minimalist aesthetic focused on clarity and performance.

## API Endpoints

- `GET /api/profile` - Basic identity information.
- `GET /api/about` - Summary and technical skills.
- `GET /api/experience` - Professional timeline.
- `GET /api/projects` - Featured work and portfolio items.
- `GET /api/hobbies` - Personal interests.
- `GET /api/contact` - Communication links.
