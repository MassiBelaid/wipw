import {Joueur} from './Joueur';

export class QuestionSimple {
  idQUestion: number;
  joueursDisp: Joueur[];
  enonce: string;
  textReponse: string;


  constructor(idQUestion: number, joueursDisp: Joueur[], enonce: string, textReponse: string) {
    this.idQUestion = idQUestion;
    this.joueursDisp = joueursDisp;
    this.enonce = enonce;
    this.textReponse = textReponse;
  }
}
