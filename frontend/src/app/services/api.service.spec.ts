import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { ApiService } from './api.service';
import { Profile, Certification } from '../models/data.models';

describe('ApiService', () => {
  let service: ApiService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [ApiService]
    });
    service = TestBed.inject(ApiService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify();
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should fetch profile', () => {
    const mockProfile: Partial<Profile> = { name: 'Makarand P. Thorat' };
    
    service.getProfile().subscribe(profile => {
      expect(profile.name).toBe('Makarand P. Thorat');
    });

    const req = httpMock.expectOne('http://localhost:8080/api/profile');
    expect(req.request.method).toBe('GET');
    req.flush(mockProfile);
  });

  it('should fetch certifications', () => {
    const mockCerts: Partial<Certification>[] = [{ title: 'Java 11', link: '#' }];

    service.getCertifications().subscribe(certs => {
      expect(certs.length).toBe(1);
      expect(certs[0].title).toBe('Java 11');
    });

    const req = httpMock.expectOne('http://localhost:8080/api/certifications');
    expect(req.request.method).toBe('GET');
    req.flush(mockCerts);
  });
});
