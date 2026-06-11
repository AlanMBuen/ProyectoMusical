import { TestBed } from '@angular/core/testing';

import { Usuariocomun } from './usuariocomun';

describe('Usuariocomun', () => {
  let service: Usuariocomun;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Usuariocomun);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
