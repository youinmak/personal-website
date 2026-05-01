import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ApiService } from '../../services/api.service';
import { Profile, Contact, About, Language } from '../../models/data.models';
import { Observable, combineLatest, map } from 'rxjs';
import { LoadingSkeletonComponent } from '../loading-skeleton/loading-skeleton.component';

@Component({
  selector: 'app-sidebar',
  standalone: true,
  imports: [CommonModule, LoadingSkeletonComponent],
  templateUrl: './sidebar.component.html'
})
export class SidebarComponent implements OnInit {
  @Input() viewMode: 'resume' | 'cover-letter' = 'resume';
  @Output() viewModeChange = new EventEmitter<'resume' | 'cover-letter'>();

  profile$!: Observable<Profile>;
  contact$!: Observable<Contact>;
  about$!: Observable<About>;
  tools$!: Observable<string[]>;
  languages$!: Observable<Language[]>;

  constructor(private apiService: ApiService) {}

  ngOnInit() {
    this.profile$ = this.apiService.getProfile();
    this.contact$ = this.apiService.getContact();
    this.about$ = this.apiService.getAbout();
    this.tools$ = this.apiService.getTools();
    this.languages$ = this.apiService.getLanguages();
  }

  setViewMode(mode: 'resume' | 'cover-letter') {
    this.viewMode = mode;
    this.viewModeChange.emit(mode);
  }
}