package com.personalwebsite.backend.dto;
import java.util.List;
public record Profile(String name, String role, String tagline, String location, String phone, List<SocialLink> socialLinks) {}
