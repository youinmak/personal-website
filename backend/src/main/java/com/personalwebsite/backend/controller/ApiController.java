package com.personalwebsite.backend.controller;

import com.personalwebsite.backend.dto.*;
import com.personalwebsite.backend.service.DataService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST Controller providing endpoints for the portfolio website data.
 * All endpoints are cross-origin enabled for the Angular frontend development environment.
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "${cors.allowed-origins:http://localhost:4200}")
public class ApiController {

    private final DataService dataService;

    public ApiController(DataService dataService) {
        this.dataService = dataService;
    }

    /**
     * @return The user's basic profile information (name, role, tagline, etc.).
     */
    @GetMapping("/profile")
    public Profile getProfile() {
        return dataService.getProfile();
    }

    /**
     * @return The "About Me" summary and high-level skills.
     */
    @GetMapping("/about")
    public About getAbout() {
        return dataService.getAbout();
    }

    /**
     * @return A list of professional experiences in chronological order.
     */
    @GetMapping("/experience")
    public List<Experience> getExperience() {
        return dataService.getExperience();
    }

    /**
     * @return A list of featured projects and portfolio items.
     */
    @GetMapping("/projects")
    public List<Project> getProjects() {
        return dataService.getProjects();
    }

    /**
     * @return A list of tools and technologies used.
     */
    @GetMapping("/tools")
    public List<String> getTools() {
        return dataService.getTools();
    }

    /**
     * @return A list of languages spoken and proficiency levels.
     */
    @GetMapping("/languages")
    public List<Language> getLanguages() {
        return dataService.getLanguages();
    }

    /**
     * @return A list of personal interests and hobbies.
     */
    @GetMapping("/hobbies")
    public List<Hobby> getHobbies() {
        return dataService.getHobbies();
    }

    /**
     * @return A list of professional certifications and credentials.
     */
    @GetMapping("/certifications")
    public List<Certification> getCertifications() {
        return dataService.getCertifications();
    }

    /**
     * @return A list of honors, nominations, and professional awards.
     */
    @GetMapping("/awards")
    public List<Award> getAwards() {
        return dataService.getAwards();
    }

    /**
     * @return Categorized technical expertise (e.g., Programming Languages, Tools).
     */
    @GetMapping("/skill-categories")
    public List<SkillCategory> getSkillCategories() {
        return dataService.getSkillCategories();
    }

    /**
     * @return Contact information (email, social profiles).
     */
    @GetMapping("/contact")
    public Contact getContact() {
        return dataService.getContact();
    }

    /**
     * @return The content for the personalized cover letter.
     */
    @GetMapping("/cover-letter")
    public CoverLetter getCoverLetter() {
        return dataService.getCoverLetter();
    }
}
