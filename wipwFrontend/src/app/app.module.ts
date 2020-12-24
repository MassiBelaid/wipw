import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { QuizComponent } from './quiz/quiz.component';
import { QuestionSimplesQuizComponent } from './question-simples-quiz/question-simples-quiz.component';
import { HttpClientModule } from '@angular/common/http';
import { SingleQuestionSimpleComponent } from './single-question-simple/single-question-simple.component';
import { Errors404Component } from './errors404/errors404.component';
import { AdminAuthentificationComponent } from './admin-authentification/admin-authentification.component';
import {ReactiveFormsModule} from '@angular/forms';
import { NavbarComponent } from './navbar/navbar.component';
import {LoginInterceptorProvider} from './interceptors/login.interceptor';
import {LoginGuard} from './guard/login.guard';
import {LogoutGuard} from './guard/logout.guard';

@NgModule({
  declarations: [
    AppComponent,
    QuizComponent,
    QuestionSimplesQuizComponent,
    SingleQuestionSimpleComponent,
    Errors404Component,
    AdminAuthentificationComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [LoginInterceptorProvider,
              LoginGuard,
              LogoutGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
