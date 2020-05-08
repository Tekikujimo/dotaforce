import { Component, OnInit } from '@angular/core';
import {RequestsService} from '../commons/services/requests-service.service';


@Component({
  selector: 'app-ranking',
  templateUrl: './ranking.component.html',
  styleUrls: ['./ranking.component.css']
})
export class RankingComponent implements OnInit {

  results:any;
  columNames:any[] = ["Puesto","Jugador","Total Asesinatos","Total Muertes","Total Oro Acumulado","Total Puntos*"]; 

  constructor(private rs:RequestsService) { }

  ngOnInit(): void {
    this.rs.getTotalResults().subscribe(r=>{
      this.results = r;
      console.log("resultados");
      console.log(this.results);
    });
  }

}
