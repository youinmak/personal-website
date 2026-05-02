package com.personalwebsite.backend.dto;

/**
 * Data Transfer Object for a professional work experience entry.
 * 
 * @param company Name of the employer.
 * @param position Job title or role.
 * @param duration Period of employment (e.g., "Jan 2020 - Present").
 * @param location Geographic location of the role.
 * @param description Key responsibilities and achievements.
 */
public record Experience(
    String company,
    String position,
    String duration,
    String location,
    String description
) {}
