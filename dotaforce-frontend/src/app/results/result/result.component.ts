import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-result',
  templateUrl: './result.component.html',
  styleUrls: ['./result.component.css']
})
export class ResultComponent implements OnInit {

  results:any;
  columNames:any[] = ["Jugador","Héroe","Asesinatos","Muertes","Oro Acumulado","Resultado","Puntos","Acciones"]; 

  constructor() { }

  ngOnInit(): void {
  }

}
