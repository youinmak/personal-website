package com.personalwebsite.backend.service;

import com.personalwebsite.backend.dto.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService {

    public Profile getProfile() {
        return new Profile(
            "Makarand P. Thorat",
            "Senior Software Developer & Architect",
            "15+ years of experience in analysis, design and development of various J2EE applications, specializing in e-commerce on the Hybris Platform.",
            "Pune, India",
            "+91 90 2155 3444",
            List.of(
                new SocialLink("LinkedIn", "https://www.linkedin.com/in/makrand-thorat-2215111b/"),
                new SocialLink("GitHub", "https://github.com/youinmak")
            ),
            List.of(
                new Qualification("B. Tech.", "College Of Engineering Pune(COEP)", "2006-10", "6.9/10 CGPA"),
                new Qualification("Higher Secondary School", "Yashwantrao Chavan College of Science, Karad", "2005-06", "84.50%"),
                new Qualification("Secondary School", "Vidhyarthi Vikas Vidhyalay", "2003-04", "83.73%")
            )
        );
    }

    public About getAbout() {
        return new About(
            "I am a highly experienced developer and architect with over 15 years in the IT industry. I hold multiple certifications including SAP Certified Development Professional (Hybris Commerce), Microsoft GitHub Copilot Certification, and Oracle Certified Professional Java SE 8/11 Programmer. My expertise spans cloud-native microservices architecture, Headless commerce, and integrating complex ERP systems with e-commerce platforms.",
            List.of("Java", "Spring Boot", "SAP Hybris", "Microservices", "AWS", "Angular", "ReactJS", "Kafka", "SQL")
        );
    }

    public List<Experience> getExperience() {
        return List.of(
            new Experience(
                "Nagarro Enterprise Services Private Limited", 
                "Senior Software Architect", 
                "Current", 
                "Pune, India", 
                "Leading multiple project modules from Cart, Checkout to OMS for high-profile clients like Amway and Tata CLiQ. Designing cloud-native microservices, integrating Generative AI tools, and providing technical mentorship to geographically distributed teams."
            )
        );
    }

    public List<Project> getProjects() {
        return List.of(
            new Project(
                "Amway ANA Development and Consulting", 
                "Design and architecture for Amway's e-commerce platform including Cart, Checkout, OMS, and payment integrations. Infrastructure implemented using AWS (DynamoDB, ECS, Lambda).", 
                List.of("Java", "Spring Cloud", "Angular", "AWS", "Kafka"), 
                "#"
            ),
            new Project(
                "Tata CLiQ/Luxury Development", 
                "Omnichannel e-commerce platform integration. Designed end-to-end commerce flows across PDP, cart, promotions, and payments using SAP Hybris OCC.", 
                List.of("SAP Hybris", "ReactJS", "Elastic", "Solr", "Microservices"), 
                "#"
            ),
            new Project(
                "iShopChangi Marketplace platform", 
                "Digital transformation project designing a new generation marketplace using SAP commerce cloud, Mirakl, and Adobe AEM.", 
                List.of("SAP Commerce Cloud", "AEM", "React", "REST APIs"), 
                "#"
            ),
            new Project(
                "Adastria B2C (Japan)", 
                "E-commerce portal development integrating Hybris commerce engine with Adobe Experience Manager CMS. Handled core DB integration and custom checkouts.", 
                List.of("Hybris", "AEM", "Zeta Search"), 
                "#"
            )
        );
    }

    public List<String> getTools() {
        return List.of(
            "IntelliJ IDEA", "Eclipse", "Git", "Maven", "Jmeter", "ActiveMQ", "Apache Solr", "AWS", "Docker", "Splunk", "Grafana"
        );
    }

    public List<Language> getLanguages() {
        return List.of(
            new Language("English", "Fluent"),
            new Language("Hindi", "Native"),
            new Language("Marathi", "Native")
        );
    }

    public List<Hobby> getHobbies() {
        return List.of(
            new Hobby("Open Source", "Exploring and contributing to new technologies."),
            new Hobby("Mentorship", "Guiding junior developers and conducting training sessions.")
        );
    }

    public Contact getContact() {
        return new Contact(
            "makarand.coep@gmail.com",
            "https://linkedin.com/in/makarand-thorat",
            "https://github.com/makarandthorat"
        );
    }

    public CoverLetter getCoverLetter() {
        return new CoverLetter(
            "May 1, 2026",
            "Hiring Manager",
            "Director of Engineering",
            "Target Company",
            "Application for Senior Software Architect Position",
            List.of(
                "I am writing to express my strong interest in the Senior Software Architect position. With over 15 years of experience in designing, developing, and deploying high-performance J2EE and e-commerce applications, I am confident in my ability to bring valuable expertise to your team.",
                "In my current role at Nagarro, I have architected and led multiple highly complex e-commerce platforms for global clients like Amway and Tata CLiQ. I specialize in SAP Hybris, Spring Boot microservices, and cloud-native architectures on AWS. Recently, I have also integrated AI coding assistants into the development lifecycle to accelerate delivery and improve solution design.",
                "I am passionate about clean architecture, scalable systems, and continuous learning, as evidenced by my certifications in Java, Spring, and Hybris. I thrive in collaborative, Agile environments and enjoy mentoring engineering teams to achieve maximum productivity.",
                "Thank you for considering my application. I have attached my resume and look forward to discussing how my technical background and leadership skills align with your organization's goals."
            ),
            "Best regards,"
        );
    }
}