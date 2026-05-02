package com.personalwebsite.backend.dto;

import java.util.List;

/**
 * Data Transfer Object for the "About" section.
 * 
 * @param summary A professional summary of the user.
 * @param skills A list of high-level technical skills.
 */
public record About(String summary, List<String> skills) {}
