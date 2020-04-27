import { Component, OnInit,Input } from '@angular/core';
import {RequestsService} from '../../services/requests-service.service';

@Component({
  selector: '[app-iterate-data-routes]',
  templateUrl: './iterate-data-routes.component.html',
  styleUrls: ['./iterate-data-routes.component.css']
})
export class IterateDataRoutesComponent implements OnInit {

  constructor(private rs:RequestsService) { }

  @Input()
  data:any

  @Input()
  keyword:any

  ngOnInit(): void {}

  deletePlayer(idPlayer): void{
    this.deleteRow(idPlayer,this.rs.deletePlayer(idPlayer).subscribe(result=>{}));  
  }

  deleteResult(idResult): void{
    this.deleteRow(idResult,this.rs.deleteResult(idResult).subscribe(result=>{}));  
  }

  deleteRow(idObject:number,deleteRowBBDD:any):void{
    for(let i = 0; i<this.data.length ; i++){
      if(this.data[i].id === idObject){
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
