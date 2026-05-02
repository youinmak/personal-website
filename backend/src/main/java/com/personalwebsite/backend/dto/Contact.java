package com.personalwebsite.backend.dto;

/**
 * Data Transfer Object for contact information.
 * 
 * @param email Professional email address.
 * @param linkedIn URL to the LinkedIn profile.
 * @param github URL to the GitHub profile.
 */
public record Contact(String email, String linkedIn, String github) {}
