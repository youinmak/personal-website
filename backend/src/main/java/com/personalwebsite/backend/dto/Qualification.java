package com.personalwebsite.backend.dto;

/**
 * Data Transfer Object for an academic qualification.
 * 
 * @param examination The name of the degree or examination.
 * @param institute The educational institution.
 * @param academicYear Period of study.
 * @param score Academic performance (CGPA or percentage).
 */
public record Qualification(
    String examination,
    String institute,
    String academicYear,
    String score
) {}
