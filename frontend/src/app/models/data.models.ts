export interface SocialLink {
  platform: string;
  url: string;
}

export interface Qualification {
  examination: string;
  institute: string;
  academicYear: string;
  score: string;
}

export interface Language {
  name: string;
  level: string;
}

export interface Profile {
  name: string;
  role: string;
  tagline: string;
  location: string;
  phone: string;
  socialLinks: SocialLink[];
  qualifications: Qualification[];
}

export interface About {
  summary: string;
  skills: string[];
}

export interface Experience {
  company: string;
  position: string;
  duration: string;
  location: string;
  description: string;
}

export interface Project {
  title: string;
  description: string;
  techStack: string[];
  link: string;
}

export interface Hobby {
  name: string;
  description: string;
}

export interface Contact {
  email: string;
  linkedIn: string;
  github: string;
}

export interface CoverLetter {
  date: string;
  recipientName: string;
  recipientTitle: string;
  companyName: string;
  subject: string;
  bodyParagraphs: string[];
  closing: string;
}
