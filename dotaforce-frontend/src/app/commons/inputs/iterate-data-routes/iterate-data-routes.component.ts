import { Component, OnInit,Input } from '@angular/core';
import {RequestsService} from '../../services/requests-service.service';

@Component({
  selector: '[app-iterate-data-routes]',
  templateUrl: './iterate-data-routes.component.html',
  styleUrls: ['./iterate-data-routes.component.css']
})
export class IterateDataRoutesComponent implements OnInit {


  actionComponent:any;

  constructor(private rs:RequestsService) { 
    this.rs.myMethod$.subscribe((data)=>{
      this.actionComponent=data;
    });
  }

  @Input()
  data:any

  @Input()
  keyword:any

  ngOnInit(): void {}

  deletePlayer(idPlayer): void{
    this.deleteRow(idPlayer,this.rs.deletePlayer(idPlayer).subscribe(result=>{}));  
  }

  deleteResult(idResult): void{
    this.deleteRow(idResult,this.rs.deleteResult(idResult).subscribe(result=>{}),true);  
  }

  deleteRow(idRow:number,deleteRowBBDD:any,isRowResult?:boolean):void{
    for(let i = 0; i<this.data.length ; i++){
      if(this.data[i].id === idRow){        
        if(isRowResult==true){
          if(this.actionComponent!=undefined){
            this.actionComponent.totalAsesinatos-=this.data[i].asesinatos;
            this.actionComponent.totalMuertes-=this.data[i].muertes;
            this.actionComponent.totalOroAcumulado-=this.data[i].oroAcumulado;
            this.actionComponent.totalPuntos-=this.data[i].puntos;
            if(this.actionComponent.totalAsesinatos <= 0 && this.actionComponent.totalMuertes <= 0 && this.actionComponent.totalOroAcumulado <= 0 && this.actionComponent.totalPuntos <= 0){
              this.actionComponent.sumResult = false;
            }
          }
        }
        let elementToRemove = this.data.indexOf(this.data[i]);
        this.data.splice(elementToRemove,1);       
        if(typeof deleteRowBBDD === 'function'){
          deleteRowBBDD();
        }
        break;
      }
    }
  }



}
