import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-register-result',
  templateUrl: './register-result.component.html',
  styleUrls: ['./register-result.component.css']
})
export class RegisterResultComponent implements OnInit {

  resultado:any;

  constructor() { }

  ngOnInit(): void {
  this.resultado = {
    numAsesinatos:0,
    numMuertes:0,
    oroAcumulado:0
  };
  }

}
