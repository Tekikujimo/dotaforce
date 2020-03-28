import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule,HttpClientJsonpModule } from '@angular/common/http';


import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { NavbarComponent } from './commons/header/navbar/navbar.component';
import { BodyContentComponent } from './commons/body-content/body-content.component';
import { AppRoutingModule } from './app-routing.module';
import { PlayerComponent } from './players/player/player.component';
import { ResultComponent } from './results/result/result.component';
import { RolComponent } from './roles/rol/rol.component';
import { UserComponent } from './users/user/user.component';
import { ActionComponent } from './actions/action/action.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavbarComponent,
    BodyContentComponent,
    PlayerComponent,
    ResultComponent,
    RolComponent,
    UserComponent,
    ActionComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    HttpClientJsonpModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
