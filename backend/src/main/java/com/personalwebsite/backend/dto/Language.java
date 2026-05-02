package com.personalwebsite.backend.dto;

/**
 * Data Transfer Object for a spoken language.
 * 
 * @param name The name of the language.
 * @param level Proficiency level (e.g., "Native", "Fluent").
 */
public record Language(String name, String level) {}
