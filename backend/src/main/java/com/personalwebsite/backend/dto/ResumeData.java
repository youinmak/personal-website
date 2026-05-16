package com.personalwebsite.backend.dto;

import java.util.List;

/**
 * Root Data Transfer Object for the entire resume data structure.
 * This class maps directly to the structure of resume-data.json.
 */
public record ResumeData(
    Profile profile,
    About about,
    List<Experience> experience,
    List<Project> projects,
    List<String> tools,
    List<Language> languages,
    List<Hobby> hobbies,
    List<Certification> certifications,
    List<Award> awards,
    List<SkillCategory> skillCategories,
    Contact contact,
    CoverLetter coverLetter
) {}
