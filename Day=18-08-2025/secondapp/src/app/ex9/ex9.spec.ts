import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Ex9 } from './ex9';

describe('Ex9', () => {
  let component: Ex9;
  let fixture: ComponentFixture<Ex9>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Ex9]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Ex9);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
