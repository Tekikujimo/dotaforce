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
  accion:string;
  title:string;
  
  constructor(private rs:RequestsService,private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.player = {};

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
          this.accion = "fas fa-user-edit";
          this.title = "Editar";
          this.player.roles = selectedRoles;

        });
     });
    }else{
      this.accion = "fas fa-user-plus";
      this.title = "Registrar";
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
