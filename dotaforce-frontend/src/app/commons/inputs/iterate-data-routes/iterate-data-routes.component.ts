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

  ngOnInit(): void {
    console.log("VER PARAMETROS");
    console.log(this.data);
    console.log(this.keyword);
  }

  deletePlayer(idPlayer): void{
    for(let i = 0; i<this.data.length ; i++){
      if(this.data[i].id === idPlayer){
        let elementToRemove = this.data.indexOf(this.data[i]);
        this.data.splice(elementToRemove,1);
        this.rs.deletePlayer(idPlayer).subscribe(result=>{});
        break;
      }
    }

  }

}
