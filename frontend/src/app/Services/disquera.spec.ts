import { TestBed } from '@angular/core/testing';

import { Disquera } from './disquera';

describe('Disquera', () => {
  let service: Disquera;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Disquera);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
