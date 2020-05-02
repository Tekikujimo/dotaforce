import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class RequestsService {

  myMethod$: Observable<any>;
  private myMethodSubject = new Subject<any>();

  constructor(private http: HttpClient) {
    this.myMethod$ = this.myMethodSubject.asObservable();
  }

  sendComponent(data) {
    console.log("Dato a enviar al componente ",data);
    this.myMethodSubject.next(data);
  }

  getPlayers():Observable<Object>{
    return this.http.get('/players/getAll');
  }

  getHeroes():Observable<Object>{
    return this.http.get('/heroes/getAll');
  }

  getPaises():Observable<Object>{
    return this.http.get('/paises/getAll');
  }

  getPlayer(idPlayer:any):Observable<Object>{
    return this.http.get('/players/getPlayer/'+idPlayer);
  } 
  
  deletePlayer(idPlayer:any):Observable<Object>{
    return this.http.delete('/players/deletePlayer/'+idPlayer);
  } 

  getResult(idResult:any):Observable<Object>{
    return this.http.get('/results/getResult/'+idResult);
  } 

  deleteResult(idResult:any):Observable<Object>{
    return this.http.delete('/results/deleteResult/'+idResult);
  } 

  getResults():Observable<Object>{
    return this.http.get('/results/getAll');
  }

  getResultsByPlayer(idPlayer):Observable<Object>{
    return this.http.get('/results/getResultsByPlayer/'+idPlayer);
  }

  getUsers():Observable<Object>{
    return this.http.get('/users/getAll');
  }

  savePlayer(player:any):Observable<Object>{
    return this.http.post('/players/savePlayer',player);
  }

  saveResult(result:any):Observable<Object>{
    return this.http.post('/results/saveResult',result);
  }


}
