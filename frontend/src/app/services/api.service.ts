import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { About, Contact, CoverLetter, Experience, Hobby, Language, Profile, Project } from '../models/data.models';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private apiUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) {}

  getProfile(): Observable<Profile> {
    return this.http.get<Profile>(`${this.apiUrl}/profile`);
  }

  getAbout(): Observable<About> {
    return this.http.get<About>(`${this.apiUrl}/about`);
  }

  getExperience(): Observable<Experience[]> {
    return this.http.get<Experience[]>(`${this.apiUrl}/experience`);
  }

  getProjects(): Observable<Project[]> {
    return this.http.get<Project[]>(`${this.apiUrl}/projects`);
  }

  getTools(): Observable<string[]> {
    return this.http.get<string[]>(`${this.apiUrl}/tools`);
  }

  getLanguages(): Observable<Language[]> {
    return this.http.get<Language[]>(`${this.apiUrl}/languages`);
  }

  getHobbies(): Observable<Hobby[]> {
    return this.http.get<Hobby[]>(`${this.apiUrl}/hobbies`);
  }

  getContact(): Observable<Contact> {
    return this.http.get<Contact>(`${this.apiUrl}/contact`);
  }

  getCoverLetter(): Observable<CoverLetter> {
    return this.http.get<CoverLetter>(`${this.apiUrl}/cover-letter`);
  }
}
