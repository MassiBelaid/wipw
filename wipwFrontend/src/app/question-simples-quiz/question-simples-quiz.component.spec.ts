import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { QuestionSimplesQuizComponent } from './question-simples-quiz.component';

describe('QuestionSimplesQuizComponent', () => {
  let component: QuestionSimplesQuizComponent;
  let fixture: ComponentFixture<QuestionSimplesQuizComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ QuestionSimplesQuizComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(QuestionSimplesQuizComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
