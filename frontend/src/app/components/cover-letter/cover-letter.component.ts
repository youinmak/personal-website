import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ApiService } from '../../services/api.service';
import { CoverLetter, Profile } from '../../models/data.models';
import { Observable } from 'rxjs';
import { LoadingSkeletonComponent } from '../loading-skeleton/loading-skeleton.component';

@Component({
  selector: 'app-cover-letter',
  standalone: true,
  imports: [CommonModule, LoadingSkeletonComponent],
  templateUrl: './cover-letter.component.html'
})
export class CoverLetterComponent implements OnInit {
  coverLetter$!: Observable<CoverLetter>;
  profile$!: Observable<Profile>;

  constructor(private apiService: ApiService) {}

  ngOnInit() {
    this.coverLetter$ = this.apiService.getCoverLetter();
    this.profile$ = this.apiService.getProfile();
  }
}