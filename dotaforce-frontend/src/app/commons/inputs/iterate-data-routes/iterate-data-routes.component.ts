import { Component, OnInit,Input } from '@angular/core';

@Component({
  selector: 'app-iterate-data-routes',
  templateUrl: './iterate-data-routes.component.html',
  styleUrls: ['./iterate-data-routes.component.css']
})
export class IterateDataRoutesComponent implements OnInit {

  constructor() { }

  @Input()
  data:any

  @Input()
  keyword:any

  ngOnInit(): void {
    console.log("VER PARAMETROS");
    console.log(this.data);
    console.log(this.keyword);
  }

}
