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
    asesinatos:0,
    muertes:0,
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
        this.resultado.puntos = 2;
      }else if(e.target.value == "Derrota"){
        this.resultado.puntos = 1;
      }
  });

  }

  saveResultado():void{
    this.rs.saveResult(this.resultado).subscribe(result=>{
      if(result!=null){
        this.resultado={};
      };
    });
  }

}
