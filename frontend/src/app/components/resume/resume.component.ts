import { Component, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ApiService } from '../../services/api.service';
import { About, Experience, Project, Hobby, Certification, Award, SkillCategory, Language } from '../../models/data.models';
import { Observable } from 'rxjs';
import { LoadingSkeletonComponent } from '../loading-skeleton/loading-skeleton.component';
import { ThemeService } from '../../services/theme.service';

/**
 * Smart Component responsible for rendering the main resume view.
 * It autonomously fetches data for experience, skills, certifications, and awards.
 */
@Component({
  selector: 'app-resume',
  standalone: true,
  imports: [CommonModule, LoadingSkeletonComponent],
  templateUrl: './resume.component.html'
})
export class ResumeComponent implements OnInit {
  about$!: Observable<About>;
  experience$!: Observable<Experience[]>;
  projects$!: Observable<Project[]>;
  hobbies$!: Observable<Hobby[]>;
  certifications$!: Observable<Certification[]>;
  awards$!: Observable<Award[]>;
  skillCategories$!: Observable<SkillCategory[]>;
  tools$!: Observable<string[]>;
  languages$!: Observable<Language[]>;

  themeService = inject(ThemeService);

  constructor(private apiService: ApiService) {}

  /**
   * Initializes component state by creating data streams from the ApiService.
   * Async pipes in the template will handle subscription and data rendering.
   */
  ngOnInit() {
    this.about$ = this.apiService.getAbout();
    this.experience$ = this.apiService.getExperience();
    this.projects$ = this.apiService.getProjects();
    this.hobbies$ = this.apiService.getHobbies();
    this.certifications$ = this.apiService.getCertifications();
    this.awards$ = this.apiService.getAwards();
    this.skillCategories$ = this.apiService.getSkillCategories();
    this.tools$ = this.apiService.getTools();
    this.languages$ = this.apiService.getLanguages();
  }
}