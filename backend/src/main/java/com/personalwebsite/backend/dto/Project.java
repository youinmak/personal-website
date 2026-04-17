package com.personalwebsite.backend.dto;
import java.util.List;
public record Project(String title, String description, List<String> techStack, String link) {}
