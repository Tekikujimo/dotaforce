import { Component, OnInit } from '@angular/core';
import {RequestsService} from '../../commons/services/requests-service.service'

@Component({
  selector: 'app-result',
  templateUrl: './result.component.html',
  styleUrls: ['./result.component.css']
})
export class ResultComponent implements OnInit {

  results:any;
  columNames:any[] = ["Jugador","Héroe","Rol","Asesinatos","Muertes","Oro Acumulado","Resultado","Puntos","Fecha de Partida","Acciones"]; 

  constructor(private rs:RequestsService) {
  }

  ngOnInit(): void {

    this.rs.getResults().subscribe(result=>{
      this.results = result;
      console.log(this.results);
    });
  }

}
