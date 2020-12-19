import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {QuestionSimple} from '../models/QuestionSimple';

@Injectable({
  providedIn: 'root'
})
export class QuestionSimpleService {

  private urlBase = 'http://localhost:8080/api/';

  constructor(private http: HttpClient) { }


  getquesions(): Observable<QuestionSimple []> {
    return this.http.get<QuestionSimple []>(this.urlBase + 'squestions');
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
