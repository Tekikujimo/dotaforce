import { Component, OnInit, Input } from '@angular/core';
import {RequestsService} from '../../../../commons/services/requests-service.service';
import { ActivatedRoute } from '@angular/router';
import * as $ from 'jquery';

@Component({
  selector: 'app-register-player',
  templateUrl: './register-player.component.html',
  styleUrls: ['./register-player.component.css']
})
export class RegisterPlayerComponent implements OnInit {

  @Input()
  edit:boolean;

  player:any;
  
  constructor(private rs:RequestsService,private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.player = {};
    console.log("SE EDITA?");
    console.log(this.edit);
    if(this.edit){
      this.route.params.subscribe(params => {
        let idPlayer = params['id'];
        let selectedRoles = [];
        this.rs.getPlayer(idPlayer).subscribe(result =>{
          this.player = result;
          console.log(this.player);
          
          this.player.roles.forEach(rol => {
            selectedRoles.push(rol.id);
            //$('#roles option[value="'+rol.id+'"]').attr('selected', 'selected');
          });

          this.player.roles = selectedRoles;

        });
     });
    }
  }

  onSubmit():void{
    console.log("ENVIAR INFO PLAYER");
    this.rs.savePlayer(this.player).subscribe(result =>{
      console.log(result);
      if(result!=null && !this.edit){
        this.player={};
      };
    });
  }

}
