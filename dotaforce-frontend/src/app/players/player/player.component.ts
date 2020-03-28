import { Component, OnInit } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';

@Component({
  selector: 'app-player',
  templateUrl: './player.component.html',
  styleUrls: ['./player.component.css']
})
export class PlayerComponent implements OnInit {

  players:any;
  columNames:any[]; 

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.columNames = ['NOMBRE','NICKNAMES','ROLES'];
    this.http.get('/players/getAll')
    .subscribe(res => {
      this.players=res;
      console.log(this.players);
    });
  }

}
