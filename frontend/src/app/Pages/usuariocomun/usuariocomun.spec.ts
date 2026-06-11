import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Usuariocomun } from './usuariocomun';

describe('Usuariocomun', () => {
  let component: Usuariocomun;
  let fixture: ComponentFixture<Usuariocomun>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Usuariocomun],
    }).compileComponents();

    fixture = TestBed.createComponent(Usuariocomun);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
