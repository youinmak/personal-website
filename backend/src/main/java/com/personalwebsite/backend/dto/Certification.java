package com.personalwebsite.backend.dto;

/**
 * Data Transfer Object for a professional certification.
 * 
 * @param title The name of the certification.
 * @param issuer The organization that issued the certification.
 * @param date The date the certification was earned.
 * @param link A verification link for the credential.
 */
public record Certification(String title, String issuer, String date, String link) {}
