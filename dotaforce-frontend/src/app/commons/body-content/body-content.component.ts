import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-body-content',
  templateUrl: './body-content.component.html',
  styleUrls: ['./body-content.component.css']
})
export class BodyContentComponent implements OnInit {


  @Input()
  columNames:any;

  @Input()
  data:any[];

  @Input()
  keyword:string;

  constructor() { }

  ngOnInit(): void {}
    
  }


