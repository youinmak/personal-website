import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-loading-skeleton',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './loading-skeleton.component.html'
})
export class LoadingSkeletonComponent {
  @Input() type: 'profile' | 'skills' | 'tools' | 'languages' | 'text-block' | 'experience' | 'projects' | 'hobbies' | 'cover-letter' | 'expertise' | 'certifications' = 'text-block';
}