package com.personalwebsite.backend.dto;

/**
 * Data Transfer Object for a professional award or recognition.
 * 
 * @param title The name of the award or nomination.
 * @param date The date or period the award was received.
 */
public record Award(String title, String date) {}
