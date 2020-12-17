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
    /*if (this.joueurs.joueursProp[choix].id_joueur === this.joueurs.reponse.id_joueur) {
      console.log('BONNE REPONSE (-;');
    } else {
      console.log('MAUVAISE REPONSE :-(');
    }*/
    this.sendResponse(this.joueurs.joueursProp[choix].id_joueur === this.joueurs.reponse.id_joueur);
  }


  sendResponse(resul: boolean) {
    this.sendResultToParent.emit(resul);
  }



   shuffle(array) {
    let currentIndex = array.length, temporaryValue, randomIndex;

    // While there remain elements to shuffle...
    while (0 !== currentIndex) {

      // Pick a remaining element...
      randomIndex = Math.floor(Math.random() * currentIndex);
      currentIndex -= 1;

      // And swap it with the current element.
      temporaryValue = array[currentIndex];
      array[currentIndex] = array[randomIndex];
      array[randomIndex] = temporaryValue;
    }

    return array;
  }
}
