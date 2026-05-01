import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ApiService } from '../../services/api.service';
import { About, Experience, Project, Hobby } from '../../models/data.models';
import { Observable } from 'rxjs';
import { LoadingSkeletonComponent } from '../loading-skeleton/loading-skeleton.component';

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

  constructor(private apiService: ApiService) {}

  ngOnInit() {
    this.about$ = this.apiService.getAbout();
    this.experience$ = this.apiService.getExperience();
    this.projects$ = this.apiService.getProjects();
    this.hobbies$ = this.apiService.getHobbies();
  }
}