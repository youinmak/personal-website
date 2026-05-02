package com.personalwebsite.backend.dto;

import java.util.List;

/**
 * Data Transfer Object for a categorized set of skills.
 * 
 * @param category The name of the skill group (e.g., "Programming Languages").
 * @param skills List of specific skills in this category.
 */
public record SkillCategory(String category, List<String> skills) {}
