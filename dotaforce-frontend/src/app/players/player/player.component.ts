import { Component, OnInit } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-player',
  templateUrl: './player.component.html',
  styleUrls: ['./player.component.css']
})
export class PlayerComponent implements OnInit {

  players:any;
  columNames:any[] = ["NOMBRE","NICKNAMES","ROLES"]; 

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.http.get('/players/getAll')
    .subscribe(res => {
      this.players=res;
      console.log(this.players);
    });
  }

}
