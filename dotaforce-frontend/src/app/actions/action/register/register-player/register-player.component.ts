import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-register-player',
  templateUrl: './register-player.component.html',
  styleUrls: ['./register-player.component.css']
})
export class RegisterPlayerComponent implements OnInit {

  player:any;
  
  constructor() { }

  ngOnInit(): void {
    
  }

  onSubmit():void{
    console.log("ENVIAR INFO PLAYER");
  }

}
