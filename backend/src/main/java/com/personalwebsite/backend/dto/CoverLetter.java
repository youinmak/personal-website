package com.personalwebsite.backend.dto;

import java.util.List;

/**
 * Data Transfer Object for the personalized cover letter.
 * 
 * @param date The date of the application.
 * @param recipientName Name of the hiring manager or recipient.
 * @param recipientTitle Professional title of the recipient.
 * @param companyName Name of the target company.
 * @param subject Subject line of the cover letter.
 * @param bodyParagraphs List of paragraphs for the letter body.
 * @param closing Formal closing statement.
 */
public record CoverLetter(
    String date,
    String recipientName,
    String recipientTitle,
    String companyName,
    String subject,
    List<String> bodyParagraphs,
    String closing
) {}
