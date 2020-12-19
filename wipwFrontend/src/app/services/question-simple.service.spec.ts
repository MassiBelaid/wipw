import { TestBed } from '@angular/core/testing';

import { QuestionSimpleService } from './question-simple.service';

describe('QuestionSimpleService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: QuestionSimpleService = TestBed.get(QuestionSimpleService);
    expect(service).toBeTruthy();
  });
});
