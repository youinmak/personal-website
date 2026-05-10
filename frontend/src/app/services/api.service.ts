import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { About, Contact, CoverLetter, Experience, Hobby, Language, Profile, Project, Certification, Award, SkillCategory } from '../models/data.models';

import { environment } from '../../environments/environment';

/**
 * Service to interact with the Spring Boot Backend API.
 * Provides methods to fetch all portfolio-related data.
 */
@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private apiUrl = environment.apiUrl;

  constructor(private http: HttpClient) {}

  /** Fetches the user's basic profile. */
  getProfile(): Observable<Profile> {
    return this.http.get<Profile>(`${this.apiUrl}/profile`);
  }

  /** Fetches the "About" summary and skills. */
  getAbout(): Observable<About> {
    return this.http.get<About>(`${this.apiUrl}/about`);
  }

  /** Fetches professional work experience. */
  getExperience(): Observable<Experience[]> {
    return this.http.get<Experience[]>(`${this.apiUrl}/experience`);
  }

  /** Fetches key projects. */
  getProjects(): Observable<Project[]> {
    return this.http.get<Project[]>(`${this.apiUrl}/projects`);
  }

  /** Fetches professional certifications. */
  getCertifications(): Observable<Certification[]> {
    return this.http.get<Certification[]>(`${this.apiUrl}/certifications`);
  }

  /** Fetches awards and nominations. */
  getAwards(): Observable<Award[]> {
    return this.http.get<Award[]>(`${this.apiUrl}/awards`);
  }

  /** Fetches skills grouped by categories. */
  getSkillCategories(): Observable<SkillCategory[]> {
    return this.http.get<SkillCategory[]>(`${this.apiUrl}/skill-categories`);
  }

  /** Fetches flat list of tools. */
  getTools(): Observable<string[]> {
    return this.http.get<string[]>(`${this.apiUrl}/tools`);
  }

  /** Fetches spoken languages. */
  getLanguages(): Observable<Language[]> {
    return this.http.get<Language[]>(`${this.apiUrl}/languages`);
  }

  /** Fetches personal interests. */
  getHobbies(): Observable<Hobby[]> {
    return this.http.get<Hobby[]>(`${this.apiUrl}/hobbies`);
  }

  /** Fetches contact information. */
  getContact(): Observable<Contact> {
    return this.http.get<Contact>(`${this.apiUrl}/contact`);
  }

  /** Fetches cover letter content. */
  getCoverLetter(): Observable<CoverLetter> {
    return this.http.get<CoverLetter>(`${this.apiUrl}/cover-letter`);
  }
}
