import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ResumeComponent } from './resume.component';
import { ApiService } from '../../services/api.service';
import { of } from 'rxjs';
import { HttpClientTestingModule } from '@angular/common/http/testing';

describe('ResumeComponent', () => {
  let component: ResumeComponent;
  let fixture: ComponentFixture<ResumeComponent>;
  let apiServiceSpy: jasmine.SpyObj<ApiService>;

  beforeEach(async () => {
    const spy = jasmine.createSpyObj('ApiService', [
      'getAbout', 'getExperience', 'getProjects', 'getHobbies', 
      'getCertifications', 'getAwards', 'getSkillCategories'
    ]);

    // Mock each method to return an empty observable by default
    spy.getAbout.and.returnValue(of({ summary: 'Test', skills: [] }));
    spy.getExperience.and.returnValue(of([]));
    spy.getProjects.and.returnValue(of([]));
    spy.getHobbies.and.returnValue(of([]));
    spy.getCertifications.and.returnValue(of([]));
    spy.getAwards.and.returnValue(of([]));
    spy.getSkillCategories.and.returnValue(of([]));

    await TestBed.configureTestingModule({
      imports: [ResumeComponent, HttpClientTestingModule],
      providers: [
        { provide: ApiService, useValue: spy }
      ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ResumeComponent);
    component = fixture.componentInstance;
    apiServiceSpy = TestBed.inject(ApiService) as jasmine.SpyObj<ApiService>;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should call all api methods on init', () => {
    expect(apiServiceSpy.getAbout).toHaveBeenCalled();
    expect(apiServiceSpy.getExperience).toHaveBeenCalled();
    expect(apiServiceSpy.getCertifications).toHaveBeenCalled();
    expect(apiServiceSpy.getSkillCategories).toHaveBeenCalled();
  });
});
