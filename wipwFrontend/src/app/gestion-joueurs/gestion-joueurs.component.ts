import { Component, OnInit } from '@angular/core';
import {Joueur} from '../models/Joueur';
import {JoueurService} from '../services/joueur.service';

@Component({
  selector: 'app-gestion-joueurs',
  templateUrl: './gestion-joueurs.component.html',
  styleUrls: ['./gestion-joueurs.component.css']
})
export class GestionJoueursComponent implements OnInit {
  joueurs: Joueur[];
  chaine: string;

  constructor(private joueursService: JoueurService) { }

  ngOnInit() {
    this.joueursService.getJoueurs().subscribe(
      joueurs => this.joueurs = joueurs
    );
    this.chaine = '';
  }

  search() {
    this.chaine = this.chaine.trim().toLocaleLowerCase();
    if (this.chaine.length) {
      this.joueursService.getJoueursWithCritere(this.chaine).subscribe(
        joueurs => this.joueurs = joueurs
      );
    } else {
      this.joueursService.getJoueurs().subscribe(
        joueurs => this.joueurs = joueurs
      );
    }
  }

  update(id: number) {
    console.log('Modification de ' + id);
  }
  delete(id: number) {
    console.log('Suppression de ' + id);
  }
  add(){
    console.log('Ajout joueur');
  }

}
