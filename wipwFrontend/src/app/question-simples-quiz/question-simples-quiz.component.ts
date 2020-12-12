import { Component, OnInit } from '@angular/core';
import {JoueurService} from '../Services/joueur.service';
import {QuestionSimpleService} from '../Services/question-simple.service';

@Component({
  selector: 'app-question-simples-quiz',
  templateUrl: './question-simples-quiz.component.html',
  styleUrls: ['./question-simples-quiz.component.css']
})
export class QuestionSimplesQuizComponent implements OnInit {

  constructor(private joueurService: JoueurService, private questionsSimpleService: QuestionSimpleService) { }

  ngOnInit() {
  }

}
