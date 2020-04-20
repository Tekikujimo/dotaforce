import { Component, OnInit } from '@angular/core';
import {RequestsService} from '../../../../commons/services/requests-service.service'

@Component({
  selector: 'app-register-result',
  templateUrl: './register-result.component.html',
  styleUrls: ['./register-result.component.css']
})
export class RegisterResultComponent implements OnInit {

  //Cambiar los anys por definicion de clases o interfaces mas adelante!!
  resultado:any;
  players:any;
  heroes:any;

  constructor(private rs:RequestsService) { }

  ngOnInit(): void {
  this.resultado = {
    numAsesinatos:0,
    numMuertes:0,
    oroAcumulado:0
  };
   
  this.rs.getPlayers().subscribe(data=>{
    this.players = data;
  });

  this.rs.getHeroes().subscribe(data=>{
    this.heroes = data;
  });

  $("#resultado").change((e:any)=>{
      if(e.target.value == "Victoria"){
        $("#puntos").val(2);
      }else if(e.target.value == "Derrota"){
        $("#puntos").val(1);
      }
  });

  }

}
