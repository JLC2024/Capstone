import { TestBed } from '@angular/core/testing';

import { ViewordersService } from './vieworders.service';

describe('ViewordersService', () => {
  let service: ViewordersService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ViewordersService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
