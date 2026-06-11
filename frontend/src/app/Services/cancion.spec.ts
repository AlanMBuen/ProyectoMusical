import { TestBed } from '@angular/core/testing';

import { Cancion } from './cancion';

describe('Cancion', () => {
  let service: Cancion;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Cancion);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
