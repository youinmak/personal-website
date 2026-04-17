package com.personalwebsite.backend.controller;

import com.personalwebsite.backend.dto.*;
import com.personalwebsite.backend.service.DataService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ApiController {

    private final DataService dataService;

    public ApiController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping("/profile")
    public Profile getProfile() {
        return dataService.getProfile();
    }

    @GetMapping("/about")
    public About getAbout() {
        return dataService.getAbout();
    }

    @GetMapping("/experience")
    public List<Experience> getExperience() {
        return dataService.getExperience();
    }

    @GetMapping("/projects")
    public List<Project> getProjects() {
        return dataService.getProjects();
    }

    @GetMapping("/tools")
    public List<String> getTools() {
        return dataService.getTools();
    }

    @GetMapping("/languages")
    public List<Language> getLanguages() {
        return dataService.getLanguages();
    }

    @GetMapping("/hobbies")
    public List<Hobby> getHobbies() {
        return dataService.getHobbies();
    }

    @GetMapping("/contact")
    public Contact getContact() {
        return dataService.getContact();
    }

    @GetMapping("/cover-letter")
    public CoverLetter getCoverLetter() {
        return dataService.getCoverLetter();
    }
}
