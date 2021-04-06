import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WizardDetailsComponent } from './wizard-details.component';

describe('WizardDetailsComponent', () => {
  let component: WizardDetailsComponent;
  let fixture: ComponentFixture<WizardDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WizardDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WizardDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
