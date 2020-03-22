import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from "rxjs/operators";

@Component({
  selector: 'app-body-content',
  templateUrl: './body-content.component.html',
  styleUrls: ['./body-content.component.css']
})
export class BodyContentComponent implements OnInit {

  jugadores:any;

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    /*this.http.jsonp("http://localhost:8090/players/getAll",'callback').pipe(map(data => {
      console.log("Inside map");

      console.log(data);
  })
  ).subscribe();*/

  this.http.get('/players/getAll')
  .subscribe(res => {
    this.jugadores=res;
    console.log(this.jugadores);

  });
  }
    
  }


