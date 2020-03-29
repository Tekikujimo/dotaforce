import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PlayerComponent } from './players/player/player.component';
import { ResultComponent } from './results/result/result.component';
import { RolComponent } from './roles/rol/rol.component';
import { UserComponent } from './users/user/user.component';
import { ActionComponent } from './actions/action/action.component';


const routes: Routes = [
  { path: '', redirectTo: 'results', pathMatch: 'full' },
  { path: 'players', component: PlayerComponent },
  { path: 'results', component: ResultComponent },
  { path: 'roles', component: RolComponent },
  { path: 'users', component: UserComponent },
  { path: 'actions/:action', component: ActionComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes,{useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
