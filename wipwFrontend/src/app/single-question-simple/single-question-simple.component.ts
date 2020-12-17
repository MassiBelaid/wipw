import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-dingle-question-simple',
  templateUrl: './single-question-simple.component.html',
  styleUrls: ['./single-question-simple.component.css']
})
export class SingleQuestionSimpleComponent implements OnInit {
  @Input() joueurs;
  @Output() sendResultToParent = new EventEmitter();

  constructor() { }

  ngOnInit() {
  }


  choisir(choix: number) {
    this.sendResponse(this.joueurs.joueursProp[choix].id_joueur === this.joueurs.reponse.id_joueur);
  }


  sendResponse(resul: boolean) {
    this.sendResultToParent.emit(resul);
  }

}
