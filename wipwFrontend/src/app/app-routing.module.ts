import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {QuizComponent} from './quiz/quiz.component';
import {QuestionSimplesQuizComponent} from './question-simples-quiz/question-simples-quiz.component';
import {Errors404Component} from './errors404/errors404.component';
import {AdminAuthentificationComponent} from './admin-authentification/admin-authentification.component';


const routes: Routes = [
  {path: '', component: QuizComponent},
  {path: 'quiz', component: QuestionSimplesQuizComponent},
  {path: 'admin-connexion', component: AdminAuthentificationComponent},
  {path: 'not-found', component: Errors404Component},
  {path: '**', redirectTo: 'not-found'}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
