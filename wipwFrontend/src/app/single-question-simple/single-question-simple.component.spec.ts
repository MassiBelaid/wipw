import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SingleQuestionSimpleComponent } from './single-question-simple.component';

describe('DingleQuestionSimpleComponent', () => {
  let component: SingleQuestionSimpleComponent;
  let fixture: ComponentFixture<SingleQuestionSimpleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SingleQuestionSimpleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SingleQuestionSimpleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
