package com.personalwebsite.backend.controller;

import com.personalwebsite.backend.dto.About;
import com.personalwebsite.backend.dto.Profile;
import com.personalwebsite.backend.service.DataService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ApiController.class)
class ApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DataService dataService;

    @Test
    void getProfile_ShouldReturnProfile() throws Exception {
        Profile mockProfile = new Profile("Test Name", "Architect", "Tagline", "Location", "Phone", List.of(), List.of());
        when(dataService.getProfile()).thenReturn(mockProfile);

        mockMvc.perform(get("/api/profile"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Test Name"))
                .andExpect(jsonPath("$.role").value("Architect"));
    }

    @Test
    void getAbout_ShouldReturnAbout() throws Exception {
        About mockAbout = new About("Summary", List.of("Skill1"));
        when(dataService.getAbout()).thenReturn(mockAbout);

        mockMvc.perform(get("/api/about"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.summary").value("Summary"))
                .andExpect(jsonPath("$.skills[0]").value("Skill1"));
    }

    @Test
    void getCertifications_ShouldReturnList() throws Exception {
        mockMvc.perform(get("/api/certifications"))
                .andExpect(status().isOk());
    }
}
