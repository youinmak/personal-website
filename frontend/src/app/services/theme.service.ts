import { Injectable, signal } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ThemeService {
  isDevMode = signal(false);

  toggleDevMode() {
    this.isDevMode.set(!this.isDevMode());
  }
}
