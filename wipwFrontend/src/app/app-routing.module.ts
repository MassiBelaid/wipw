import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {QuizComponent} from './quiz/quiz.component';
import {QuestionSimplesQuizComponent} from './question-simples-quiz/question-simples-quiz.component';


const routes: Routes = [
  {path: '', component: QuizComponent},
  {path: 'quiz', component: QuestionSimplesQuizComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
