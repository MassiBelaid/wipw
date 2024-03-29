import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Errors404Component } from './errors404.component';

describe('Errors404ComponentComponent', () => {
  let component: Errors404Component;
  let fixture: ComponentFixture<Errors404Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Errors404Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Errors404Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
