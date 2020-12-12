export class Joueur {
  idJoueur: number;
  nom: string;
  prenom: string;
  dateNaissance: Date;
  urlImage: string;
  nationnalite: string;
  surnom: string;
  dateDebut: Date;
  dateFin: Date;
  constructor(idJoueur: number, nom: string, prenom: string, dateNaissance: Date, urlImage: string,
              nationnalite: string, surnom: string, dateDebut: Date, dateFin: Date) {
    this.idJoueur = idJoueur;
    this.nom = nom;
    this.prenom = prenom;
    this.dateNaissance = dateNaissance;
    this.urlImage = urlImage;
    this.nationnalite = nationnalite;
    this.surnom = surnom;
    this.dateDebut = dateDebut;
    this.dateFin = dateFin;
  }
}
