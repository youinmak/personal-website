import { ComponentFixture, TestBed } from '@angular/core/testing';
import { SidebarComponent } from './sidebar.component';
import { ApiService } from '../../services/api.service';
import { of } from 'rxjs';
import { HttpClientTestingModule } from '@angular/common/http/testing';

describe('SidebarComponent', () => {
  let component: SidebarComponent;
  let fixture: ComponentFixture<SidebarComponent>;
  let apiServiceSpy: jasmine.SpyObj<ApiService>;

  beforeEach(async () => {
    const spy = jasmine.createSpyObj('ApiService', ['getProfile', 'getContact', 'getAbout', 'getTools', 'getLanguages']);
    spy.getProfile.and.returnValue(of({ name: 'Test', role: 'Role', socialLinks: [], qualifications: [] }));
    spy.getContact.and.returnValue(of({ email: 'test@test.com', linkedIn: '', github: '' }));
    spy.getAbout.and.returnValue(of({ summary: '', skills: [] }));
    spy.getTools.and.returnValue(of([]));
    spy.getLanguages.and.returnValue(of([]));

    await TestBed.configureTestingModule({
      imports: [SidebarComponent, HttpClientTestingModule],
      providers: [
        { provide: ApiService, useValue: spy }
      ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SidebarComponent);
    component = fixture.componentInstance;
    apiServiceSpy = TestBed.inject(ApiService) as jasmine.SpyObj<ApiService>;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should call profile, contact, and about methods', () => {
    expect(apiServiceSpy.getProfile).toHaveBeenCalled();
    expect(apiServiceSpy.getContact).toHaveBeenCalled();
    expect(apiServiceSpy.getAbout).toHaveBeenCalled();
  });
});
