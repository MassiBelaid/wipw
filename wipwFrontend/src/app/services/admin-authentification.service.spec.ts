import { TestBed } from '@angular/core/testing';

import { AdminAuthentificationService } from './admin-authentification.service';

describe('AdminAuthentificationService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AdminAuthentificationService = TestBed.get(AdminAuthentificationService);
    expect(service).toBeTruthy();
  });
});
