import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-body-content',
  templateUrl: './body-content.component.html',
  styleUrls: ['./body-content.component.css']
})
export class BodyContentComponent implements OnInit {


  @Input('columnNames')
  columNames:any;

  @Input('data')
  data:any[];

  constructor() { }

  ngOnInit(): void {
    console.log("COLUMNS");
    console.log(this.columNames);
  }
    
  }


