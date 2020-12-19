import {Joueur} from './Joueur';

export class QuestionSimple {
  idQUestion: number;
  joueursDisp: Joueur[];
  reponse: Joueur;
  joueursProp: Joueur[];
  enonce: string;
  textReponse: string;

  constructor(idQUestion: number, joueursDisp: Joueur[], reponse: Joueur,
              joueursProp: Joueur[], enonce: string, textReponse: string) {
    this.idQUestion = idQUestion;
    this.joueursDisp = joueursDisp;
    this.reponse = reponse;
    this.joueursProp = joueursProp;
    this.enonce = enonce;
    this.textReponse = textReponse;
  }
}
