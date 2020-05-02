import { Component, OnInit} from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {RequestsService} from '../../commons/services/requests-service.service'
import * as $ from 'jquery';

@Component({
  selector: 'app-action',
  templateUrl: './action.component.html',
  styleUrls: ['./action.component.css']
})
export class ActionComponent implements OnInit{

  accion:string;
  idJugador:number;
  columNames:any[];
  results:any;
  sumResult:boolean;
  totalAsesinatos:number = 0;
  totalMuertes:number = 0;
  totalOroAcumulado:number = 0;
  totalPuntos:number = 0;

  constructor(private route: ActivatedRoute, private rs:RequestsService) {
  }

  ngOnInit(): void {
    this.checkPlayerResults();
  }

  checkPlayerResults():void{
    this.route.params.subscribe(params => {
      this.accion = params['action'];

      if(this.accion == "checkPlayerResults"){
        this.idJugador = params['id'];
        this.loadPlayerResults(this.idJugador);
      }
   });
  }


  loadPlayerResults(idJugador:number):void{
    this.columNames = ["Jugador","Héroe","Rol","Asesinatos","Muertes","Oro Acumulado","Resultado","Puntos","Fecha de Partida","Acciones"]; 
    this.rs.getResultsByPlayer(idJugador).subscribe(result=>{
      this.results = result;
      if(this.results.length>0){
        this.sumResult = true;
        for(let i=0;i<this.results.length;i++){
          this.totalAsesinatos+=this.results[i].asesinatos;
          this.totalMuertes+=this.results[i].muertes;
          this.totalOroAcumulado+=this.results[i].oroAcumulado;
          this.totalPuntos+=this.results[i].puntos;
          this.rs.sendComponent(this);
        }
      }else{
        this.sumResult = false;
      }
    });
  }

}
