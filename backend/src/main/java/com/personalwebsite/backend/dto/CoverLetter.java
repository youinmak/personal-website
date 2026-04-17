package com.personalwebsite.backend.dto;

import java.util.List;

public record CoverLetter(
    String date,
    String recipientName,
    String recipientTitle,
    String companyName,
    String subject,
    List<String> bodyParagraphs,
    String closing
) {}
