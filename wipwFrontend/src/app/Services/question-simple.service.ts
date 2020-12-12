import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class QuestionSimpleService {

  private urlBase = 'http://localhost:8080/api/';

  constructor(private http: HttpClient) { }


  getquesions(): Observable<any> {
    return this.http.get(this.urlBase + 'squestions');
  }
}
