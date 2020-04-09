import { Component, OnInit } from '@angular/core';
import {RequestsService} from '../../../../commons/services/requests-service.service';

@Component({
  selector: 'app-register-player',
  templateUrl: './register-player.component.html',
  styleUrls: ['./register-player.component.css']
})
export class RegisterPlayerComponent implements OnInit {

  player:any;
  
  constructor(private rs:RequestsService) { }

  ngOnInit(): void {
    this.player = {};
  }

  onSubmit():void{
    console.log("ENVIAR INFO PLAYER");
    this.rs.savePlayer(this.player).subscribe(result =>{
      console.log(result);
    });
  }

}
