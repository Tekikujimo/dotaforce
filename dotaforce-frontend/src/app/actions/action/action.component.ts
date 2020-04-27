import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {RequestsService} from '../../commons/services/requests-service.service'


@Component({
  selector: 'app-action',
  templateUrl: './action.component.html',
  styleUrls: ['./action.component.css']
})
export class ActionComponent implements OnInit {

  accion:string;
  idJugador:number;
  columNames:any[];
  results:any;

  constructor(private route: ActivatedRoute, private rs:RequestsService) { }

  ngOnInit(): void {
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
    });
  }

}
