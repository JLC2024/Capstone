import { TestBed } from '@angular/core/testing';

import { OderformService } from './orderform.service';

describe('OderformService', () => {
  let service: OderformService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OderformService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
