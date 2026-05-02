import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CoverLetterComponent } from './cover-letter.component';
import { ApiService } from '../../services/api.service';
import { of } from 'rxjs';
import { HttpClientTestingModule } from '@angular/common/http/testing';

describe('CoverLetterComponent', () => {
  let component: CoverLetterComponent;
  let fixture: ComponentFixture<CoverLetterComponent>;
  let apiServiceSpy: jasmine.SpyObj<ApiService>;

  beforeEach(async () => {
    const spy = jasmine.createSpyObj('ApiService', ['getCoverLetter', 'getProfile']);
    spy.getCoverLetter.and.returnValue(of({
      date: 'May 1, 2026',
      recipientName: 'Manager',
      recipientTitle: 'Director',
      companyName: 'Company',
      subject: 'Subject',
      bodyParagraphs: ['P1'],
      closing: 'Best'
    }));
    spy.getProfile.and.returnValue(of({ name: 'Test', role: 'Role', socialLinks: [], qualifications: [] }));

    await TestBed.configureTestingModule({
      imports: [CoverLetterComponent, HttpClientTestingModule],
      providers: [
        { provide: ApiService, useValue: spy }
      ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CoverLetterComponent);
    component = fixture.componentInstance;
    apiServiceSpy = TestBed.inject(ApiService) as jasmine.SpyObj<ApiService>;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should call getCoverLetter and getProfile', () => {
    expect(apiServiceSpy.getCoverLetter).toHaveBeenCalled();
    expect(apiServiceSpy.getProfile).toHaveBeenCalled();
  });
});
