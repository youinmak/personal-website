package com.personalwebsite.backend.service;

import com.personalwebsite.backend.dto.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService {

    public Profile getProfile() {
        return new Profile(
            "John Doe",
            "Senior Full Stack Developer",
            "Passionate about building scalable web applications and mentorship.",
            "San Francisco, CA",
            "+1 (555) 000-0000",
            List.of(
                new SocialLink("LinkedIn", "https://linkedin.com/in/johndoe"),
                new SocialLink("GitHub", "https://github.com/johndoe"),
                new SocialLink("Twitter", "https://twitter.com/johndoe")
            )
        );
    }

    public About getAbout() {
        return new About(
            "I am a results-oriented Senior Full Stack Developer with over 8 years of experience in designing, developing, and deploying high-performance web applications. Expertise in Java/Spring Boot ecosystems and modern frontend frameworks like Angular and React. Proven track record of leading cross-functional teams and delivering complex projects on time.",
            List.of("Strategic Planning", "System Architecture", "Team Leadership", "Agile Methodologies", "Cloud Computing")
        );
    }

    public List<Experience> getExperience() {
        return List.of(
            new Experience("Tech Innovators Inc.", "Senior Software Engineer", "Jan 2021 - Present", "San Francisco, CA", "Leading the migration of monolithic services to a microservices architecture. Reduced system latency by 40% using Redis and Kafka."),
            new Experience("Global Solutions Corp.", "Software Engineer", "Jun 2017 - Dec 2020", "New York, NY", "Developed core features for a high-traffic e-commerce platform. Optimized database queries and improved frontend load times by 25%."),
            new Experience("Startup Hub", "Junior Developer", "Aug 2015 - May 2017", "Austin, TX", "Worked on several MVP projects using React and Node.js. Integrated third-party APIs for payment processing and analytics.")
        );
    }

    public List<Project> getProjects() {
        return List.of(
            new Project("CloudScale Analytics", "A real-time analytics dashboard for cloud infrastructure.", List.of("Spring Boot", "React", "AWS", "Prometheus"), "https://github.com/johndoe/cloudscale"),
            new Project("SecurePay Gateway", "A robust and secure payment gateway integration.", List.of("Java", "Spring Security", "Stripe API"), "https://github.com/johndoe/securepay"),
            new Project("TaskFlow Pro", "An enterprise-level project management tool.", List.of("Angular", "Node.js", "MongoDB"), "https://github.com/johndoe/taskflow")
        );
    }

    public List<String> getTools() {
        return List.of(
            "IntelliJ IDEA", "VS Code", "Docker", "Kubernetes", "Jira", "Jenkins", "Git", "Postman"
        );
    }

    public List<Language> getLanguages() {
        return List.of(
            new Language("English", "Native"),
            new Language("Spanish", "Professional Working"),
            new Language("German", "Elementary")
        );
    }

    public List<Hobby> getHobbies() {
        return List.of(
            new Hobby("Mountain Biking", "Exploring challenging trails."),
            new Hobby("Open Source", "Contributing to various software projects."),
            new Hobby("Chess", "Playing in local tournaments.")
        );
    }

    public Contact getContact() {
        return new Contact(
            "john.doe@techinnovators.com",
            "https://linkedin.com/in/johndoe",
            "https://github.com/johndoe"
        );
    }

    public CoverLetter getCoverLetter() {
        return new CoverLetter(
            "October 24, 2023",
            "Hiring Manager",
            "Director of Engineering",
            "Innovation Labs",
            "Application for Senior Full Stack Developer Position",
            List.of(
                "I am writing to express my strong interest in the Senior Full Stack Developer position at Innovation Labs. Having followed your recent breakthroughs in AI-driven automation, I am inspired by your commitment to technical excellence and user-centric design. With over 8 years of experience in the Java/Spring and Angular ecosystems, I am confident that my background makes me an ideal fit for your team.",
                "In my current role at Tech Innovators Inc., I led the migration of our legacy monolith to a distributed microservices architecture, which improved system uptime by 30% and allowed for 5x faster feature deployment. I specialize in building robust backend systems while ensuring the frontend remains intuitive and highly performant. My approach is always data-driven, and I thrive in collaborative environments where innovation is the priority.",
                "I am particularly drawn to Innovation Labs because of your focus on solving complex scale challenges. I am eager to bring my expertise in system architecture and cloud-native development to help you achieve your goal of revolutionizing the enterprise software space. I am confident that my passion for clean code and mentorship would be a valuable asset to your engineering culture.",
                "Thank you for your time and consideration. I have attached my resume and look forward to the possibility of discussing how my skills can contribute to the continued success of Innovation Labs."
            ),
            "Best regards,"
        );
    }
}
