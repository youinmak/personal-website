package com.personalwebsite.backend.dto;

/**
 * Data Transfer Object for a social media or professional link.
 * 
 * @param platform The name of the platform (e.g., "LinkedIn").
 * @param url The link to the profile.
 */
public record SocialLink(String platform, String url) {}
