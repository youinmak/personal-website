package com.personalwebsite.backend.dto;

import java.util.List;

/**
 * Data Transfer Object for the complete profile information.
 * 
 * @param name The user's full name.
 * @param role Current professional title.
 * @param tagline A short professional catchphrase.
 * @param location Current location.
 * @param phone Contact phone number.
 * @param socialLinks List of social media profiles.
 * @param qualifications List of academic qualifications.
 */
public record Profile(
    String name,
    String role,
    String tagline,
    String location,
    String phone,
    List<SocialLink> socialLinks,
    List<Qualification> qualifications
) {}
