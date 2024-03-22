import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LespostComponent } from './lespost.component';

describe('LespostComponent', () => {
  let component: LespostComponent;
  let fixture: ComponentFixture<LespostComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LespostComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(LespostComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
