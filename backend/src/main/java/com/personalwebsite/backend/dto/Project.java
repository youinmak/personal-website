package com.personalwebsite.backend.dto;

import java.util.List;

/**
 * Data Transfer Object for a portfolio project.
 * 
 * @param title The name of the project.
 * @param description A summary of the project goals and implementation.
 * @param techStack List of technologies used in the project.
 * @param link External link to the project or source code.
 */
public record Project(
    String title,
    String description,
    List<String> techStack,
    String link
) {}
