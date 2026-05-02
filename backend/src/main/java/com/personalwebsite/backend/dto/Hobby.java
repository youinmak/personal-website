package com.personalwebsite.backend.dto;

/**
 * Data Transfer Object for a personal hobby or interest.
 * 
 * @param name The name of the hobby.
 * @param description A brief description of the interest.
 */
public record Hobby(String name, String description) {}
