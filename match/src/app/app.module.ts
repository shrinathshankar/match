import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import {AppRoutingModule, routingComponent} from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {SignInComponent} from "./sign-in/sign-in.component";
import {SignUpComponent} from "./sign-up/sign-up.component";
import { HomePageComponent } from './home-page/home-page.component';
import { LadderComponent } from './ladder/ladder.component';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { LeaderboardComponent } from './ladder/leaderboard/leaderboard.component';


@NgModule({
  declarations: [
    AppComponent,
    SignInComponent,
    SignUpComponent,
    routingComponent,
    HomePageComponent,
    LadderComponent,
    LandingPageComponent,
    LeaderboardComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        FormsModule,
        ReactiveFormsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
