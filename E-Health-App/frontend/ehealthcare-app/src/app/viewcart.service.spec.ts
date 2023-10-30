import { TestBed } from '@angular/core/testing';

import { ViewcartService } from './viewcart.service';

describe('ViewcartService', () => {
  let service: ViewcartService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ViewcartService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
