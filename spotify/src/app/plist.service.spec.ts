import { TestBed } from '@angular/core/testing';

import { PlistService } from './plist.service';

describe('PlistService', () => {
  let service: PlistService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PlistService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
