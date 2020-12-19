import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-dingle-question-simple',
  templateUrl: './single-question-simple.component.html',
  styleUrls: ['./single-question-simple.component.css']
})
export class SingleQuestionSimpleComponent implements OnInit {
  @Input() question;
  @Output() sendResultToParent = new EventEmitter();

  constructor() { }

  ngOnInit() {
  }


  choisir(choix: number) {
    this.sendResponse(this.question.joueursProp[choix].id_joueur === this.question.reponse.id_joueur);
  }


  sendResponse(resul: boolean) {
    this.sendResultToParent.emit(resul);
  }

}
