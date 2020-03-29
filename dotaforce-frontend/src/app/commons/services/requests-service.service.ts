import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class RequestsService {

  constructor(private http: HttpClient) { }

  getPlayers():Observable<Object>{
    return this.http.get('/players/getAll');
  }

  getResults():Observable<Object>{
    return this.http.get('/results/getAll');
  }

  getRoles():Observable<Object>{
    return this.http.get('/roles/getAll');
  }

  getUsers():Observable<Object>{
    return this.http.get('/users/getAll');
  }
}
