import { Component, OnInit } from '@angular/core';
import {QuestionSimpleService} from '../Services/question-simple.service';

@Component({
  selector: 'app-question-simples-quiz',
  templateUrl: './question-simples-quiz.component.html',
  styleUrls: ['./question-simples-quiz.component.css']
})
export class QuestionSimplesQuizComponent implements OnInit {
   private joueurs: any[] = new Array();
   private questions: any[] = new Array();
   private numQuestion: number;

  constructor( private questionsSimpleService: QuestionSimpleService) { }

  ngOnInit() {
    this.numQuestion = 0;
    this.questionsSimpleService.getquesions().subscribe(
      questions => {
        this.questions = questions;
      }
    );


  }

}
