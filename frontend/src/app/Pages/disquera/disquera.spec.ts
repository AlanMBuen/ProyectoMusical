import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Disquera } from './disquera';

describe('Disquera', () => {
  let component: Disquera;
  let fixture: ComponentFixture<Disquera>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Disquera],
    }).compileComponents();

    fixture = TestBed.createComponent(Disquera);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
