import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule,HttpClientJsonpModule } from '@angular/common/http';
import {FormsModule} from "@angular/forms";


import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { NavbarComponent } from './commons/header/navbar/navbar.component';
import { BodyContentComponent } from './commons/body-content/body-content.component';
import { AppRoutingModule } from './app-routing.module';
import { PlayerComponent } from './players/player/player.component';
import { ResultComponent } from './results/result/result.component';
import { UserComponent } from './users/user/user.component';
import { ActionComponent } from './actions/action/action.component';
import { IterateDataRoutesComponent } from './commons/inputs/iterate-data-routes/iterate-data-routes.component';

//Services
import {RequestsService} from './commons/services/requests-service.service';
import { RegisterPlayerComponent } from './actions/action/register/register-player/register-player.component';
import { RegisterResultComponent } from './actions/action/register/register-result/register-result.component';
import { RegisterUserComponent } from './actions/action/register/register-user/register-user.component';
import { RankingComponent } from './ranking/ranking.component'

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavbarComponent,
    BodyContentComponent,
    PlayerComponent,
    ResultComponent,
    UserComponent,
    ActionComponent,
    IterateDataRoutesComponent,
    RegisterPlayerComponent,
    RegisterResultComponent,
    RegisterUserComponent,
    RankingComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    HttpClientJsonpModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [RequestsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
