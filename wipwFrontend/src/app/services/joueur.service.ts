import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable} from 'rxjs';
import {Joueur} from '../models/Joueur';

@Injectable({
  providedIn: 'root'
})
export class JoueurService {

  private urlBase = 'http://localhost:8080/';

  constructor(private http: HttpClient) { }


  getJoueurs(): Observable<Joueur []> {
    return this.http.get<Joueur []>(this.urlBase + 'api/joueurs');
  }

  getJoueursWithCritere(chaine: string): Observable<Joueur []> {
    return this.http.get<Joueur []>(this.urlBase + 'api/joueurs/mult/' + chaine);
  }
}
