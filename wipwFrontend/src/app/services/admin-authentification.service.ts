import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Admin} from '../models/Admin';

@Injectable({
  providedIn: 'root'
})
export class AdminAuthentificationService {

  private urlBase = 'http://localhost:8080/api/';

  constructor(private httpClient: HttpClient) { }

  connexion(admin: Admin): Observable<any> {
    return this.httpClient.post(this.urlBase + 'admin/connexion', admin);
  }
}
