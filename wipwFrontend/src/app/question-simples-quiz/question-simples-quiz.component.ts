import { Component, OnInit } from '@angular/core';
import {JoueurService} from '../Services/joueur.service';
import {QuestionSimpleService} from '../Services/question-simple.service';

@Component({
  selector: 'app-question-simples-quiz',
  templateUrl: './question-simples-quiz.component.html',
  styleUrls: ['./question-simples-quiz.component.css']
})
export class QuestionSimplesQuizComponent implements OnInit {
   private joueurs: Object[] = new Array();
   private questions: Object[] = new Array();

  constructor(private joueurService: JoueurService, private questionsSimpleService: QuestionSimpleService) { }

  ngOnInit() {
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
