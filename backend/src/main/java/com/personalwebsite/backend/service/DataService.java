package com.personalwebsite.backend.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.personalwebsite.backend.dto.*;
import jakarta.annotation.PostConstruct;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Service responsible for managing and providing access to the portfolio data.
 * The data is externalized in a JSON file to allow content updates without recompilation.
 */
@Service
public class DataService {

    private ResumeData resumeData;
    private final ObjectMapper objectMapper;

    /**
     * Constructor for DataService.
     * @param objectMapper Jackson ObjectMapper for JSON processing.
     */
    public DataService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    /**
     * Initializes the service by loading the resume data from the classpath resources.
     * This method is called automatically after the bean is constructed.
     * @throws IOException If there is an error reading the resume-data.json file.
     */
    @PostConstruct
    public void init() throws IOException {
        ClassPathResource resource = new ClassPathResource("resume-data.json");
        this.resumeData = objectMapper.readValue(resource.getInputStream(), ResumeData.class);
    }

    /** @return Basic profile information. */
    public Profile getProfile() {
        return resumeData.profile();
    }

    /** @return "About Me" summary and key skills. */
    public About getAbout() {
        return resumeData.about();
    }

    /** @return List of professional work experiences. */
    public List<Experience> getExperience() {
        return resumeData.experience();
    }

    /** @return List of portfolio projects. */
    public List<Project> getProjects() {
        return resumeData.projects();
    }

    /** @return Flat list of technical tools. */
    public List<String> getTools() {
        return resumeData.tools();
    }

    /** @return List of spoken languages. */
    public List<Language> getLanguages() {
        return resumeData.languages();
    }

    /** @return List of personal hobbies. */
    public List<Hobby> getHobbies() {
        return resumeData.hobbies();
    }

    /** @return List of professional certifications with links. */
    public List<Certification> getCertifications() {
        return resumeData.certifications();
    }

    /** @return List of professional awards and nominations. */
    public List<Award> getAwards() {
        return resumeData.awards();
    }

    /** @return Grouped skill categories for structured display. */
    public List<SkillCategory> getSkillCategories() {
        return resumeData.skillCategories();
    }

    /** @return Primary contact and social media information. */
    public Contact getContact() {
        return resumeData.contact();
    }

    /** @return Formatted cover letter content. */
    public CoverLetter getCoverLetter() {
        return resumeData.coverLetter();
    }
}
