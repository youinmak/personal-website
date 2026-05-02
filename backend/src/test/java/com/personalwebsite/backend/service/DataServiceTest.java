package com.personalwebsite.backend.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.personalwebsite.backend.dto.ResumeData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class DataServiceTest {

    private DataService dataService;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() throws IOException {
        objectMapper = new ObjectMapper();
        dataService = new DataService(objectMapper);
        dataService.init();
    }

    @Test
    void testDataLoading() {
        assertNotNull(dataService.getProfile(), "Profile should not be null");
        assertEquals("Makarand P. Thorat", dataService.getProfile().name());
        assertFalse(dataService.getExperience().isEmpty(), "Experience list should not be empty");
        assertFalse(dataService.getCertifications().isEmpty(), "Certifications list should not be empty");
    }

    @Test
    void testGetSkillCategories() {
        var categories = dataService.getSkillCategories();
        assertNotNull(categories);
        assertTrue(categories.stream().anyMatch(c -> c.category().equals("Programming Languages")));
    }
}
