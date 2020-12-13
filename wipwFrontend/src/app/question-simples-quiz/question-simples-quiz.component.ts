import { Component, OnInit } from '@angular/core';
import {JoueurService} from '../Services/joueur.service';
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

  constructor(private joueurService: JoueurService, private questionsSimpleService: QuestionSimpleService) { }

  ngOnInit() {
    this.numQuestion = 0;
    this.questionsSimpleService.getquesions().subscribe(
      questions => {
        this.questions = questions;
      }
    );

    this.joueurService.getJoueurs().subscribe(
      joueurs => {
        this.joueurs = joueurs;
      }
    );

  }

}
