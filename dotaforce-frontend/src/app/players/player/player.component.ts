import { Component, OnInit } from '@angular/core';
import {RequestsService} from '../../commons/services/requests-service.service'


@Component({
  selector: 'app-player',
  templateUrl: './player.component.html',
  styleUrls: ['./player.component.css']
})
export class PlayerComponent implements OnInit {

  players:any;
  columNames:any[] = ["NOMBRE","NICKNAMES","ROLES"]; 

  constructor(private rs:RequestsService) { }

  ngOnInit(): void {
    this.rs.getPlayers().subscribe(res => {
      this.players=res;
      console.log(this.players);
    });

  }

}
