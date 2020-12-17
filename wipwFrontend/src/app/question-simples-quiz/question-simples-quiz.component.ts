import { Component, OnInit } from '@angular/core';
import {QuestionSimpleService} from '../Services/question-simple.service';

@Component({
  selector: 'app-question-simples-quiz',
  templateUrl: './question-simples-quiz.component.html',
  styleUrls: ['./question-simples-quiz.component.css']
})
export class QuestionSimplesQuizComponent implements OnInit {
   private questions: any[] = new Array();
   private numQuestion: number;
   private score: number;

  constructor( private questionsSimpleService: QuestionSimpleService) { }

  ngOnInit() {
    this.numQuestion = 0;
    this.score = 0;
    this.questionsSimpleService.getquesions().subscribe(
      questions => {
        this.questions = this.questionsSimpleService.shuffle(questions);
      }
    );
  }

  getResult(result: boolean) {
    if (result) {
      this.score++;
      console.log('BONNE REPONSE (-;');
    } else {
      console.log('MAUVAISE REPONSE :-(');
    }
    this.numQuestion++;
  }

}
