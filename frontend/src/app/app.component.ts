import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ApiService } from './services/api.service';
import { About, Contact, CoverLetter, Experience, Hobby, Language, Profile, Project } from './models/data.models';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {
  profile$!: Observable<Profile>;
  about$!: Observable<About>;
  experience$!: Observable<Experience[]>;
  projects$!: Observable<Project[]>;
  tools$!: Observable<string[]>;
  languages$!: Observable<Language[]>;
  hobbies$!: Observable<Hobby[]>;
  contact$!: Observable<Contact>;
  coverLetter$!: Observable<CoverLetter>;

  isDarkMode = false;
  today = new Date();
  viewMode: 'resume' | 'cover-letter' = 'resume';

  constructor(private apiService: ApiService) {}

  ngOnInit(): void {
    this.profile$ = this.apiService.getProfile();
    this.about$ = this.apiService.getAbout();
    this.experience$ = this.apiService.getExperience();
    this.projects$ = this.apiService.getProjects();
    this.tools$ = this.apiService.getTools();
    this.languages$ = this.apiService.getLanguages();
    this.hobbies$ = this.apiService.getHobbies();
    this.contact$ = this.apiService.getContact();
    this.coverLetter$ = this.apiService.getCoverLetter();

    // Check system preference for dark mode
    if (window.matchMedia('(prefers-color-scheme: dark)').matches) {
      this.isDarkMode = true;
    }
  }

  toggleDarkMode(): void {
    this.isDarkMode = !this.isDarkMode;
  }
}
