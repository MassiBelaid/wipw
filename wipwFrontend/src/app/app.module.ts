import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { QuizComponent } from './quiz/quiz.component';
import { QuestionSimplesQuizComponent } from './question-simples-quiz/question-simples-quiz.component';
import { HttpClientModule } from '@angular/common/http';
import { SingleQuestionSimpleComponent } from './single-question-simple/single-question-simple.component';
import { Errors404Component } from './errors404/errors404.component';

@NgModule({
  declarations: [
    AppComponent,
    QuizComponent,
    QuestionSimplesQuizComponent,
    SingleQuestionSimpleComponent,
    Errors404Component
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
