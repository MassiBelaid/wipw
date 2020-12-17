import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {QuizComponent} from './quiz/quiz.component';
import {QuestionSimplesQuizComponent} from './question-simples-quiz/question-simples-quiz.component';
import {Errors404Component} from './errors404/errors404.component';


const routes: Routes = [
  {path: '', component: QuizComponent},
  {path: 'quiz', component: QuestionSimplesQuizComponent},
  {path: '**', component: Errors404Component}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
