import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TerrazzoBackgroundComponent } from './terrazzo-background.component';

describe('TerrazzoBackgroundComponent', () => {
  let component: TerrazzoBackgroundComponent;
  let fixture: ComponentFixture<TerrazzoBackgroundComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TerrazzoBackgroundComponent]
    });
    fixture = TestBed.createComponent(TerrazzoBackgroundComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
