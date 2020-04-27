import { Component, OnInit , Input } from '@angular/core';
import {RequestsService} from '../../../../commons/services/requests-service.service'
import { ActivatedRoute } from '@angular/router';

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
  @Input()
  edit:boolean;
  accion:string;

  constructor(private rs:RequestsService,private route:ActivatedRoute) {}

  ngOnInit(): void {

  this.resultado = {
    asesinatos:0,
    muertes:0,
    oroAcumulado:0
  };

  if(this.edit){  
  this.resultado["jugador"] = {};
    this.route.params.subscribe(params => {
      let idResultado = params['id'];
      this.rs.getResult(idResultado).subscribe(result =>{
        this.resultado = result;
        console.log(this.resultado);
      });      
    }); 
    this.accion = "Editar";
  }else{
    this.accion = "Registrar";
  }
   
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
      if(result!=null && !this.edit){
        this.resultado = {
          asesinatos:0,
          muertes:0,
          oroAcumulado:0
        };
      };
    });
  }

}
