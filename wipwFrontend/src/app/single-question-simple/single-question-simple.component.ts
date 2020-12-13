import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-dingle-question-simple',
  templateUrl: './single-question-simple.component.html',
  styleUrls: ['./single-question-simple.component.css']
})
export class SingleQuestionSimpleComponent implements OnInit {
  @Input() joueurs;
  @Input() propositions;
  private choix: any[] = new Array();

  constructor() { }

  ngOnInit() {
    console.log('ICII' + this.joueurs.joueursDisp[3]);
    /*this.choix.push(this.joueurs.joueursDisp[3]);
    console.log('ICII' + this.joueurs.joueursDisp[3]);
    for (const proposition of this.propositions) {
      console.log(proposition);
      if (proposition.id_joueur !== this.joueurs.joueursDisp[0].id_joueur &&
        proposition.id_joueur !== this.joueurs.joueursDisp[1].id_joueur &&
        proposition.id_joueur !== this.joueurs.joueursDisp[2].id_joueur &&
        proposition.id_joueur !== this.joueurs.joueursDisp[3].id_joueur) {
          this.choix.push(proposition);
      }
    }*/
    //this.choix = this.shuffle(this.choix);
  }



   shuffle(array) {
    var currentIndex = array.length, temporaryValue, randomIndex;

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
