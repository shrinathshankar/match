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
import { MatchHistoryComponent } from './ladder/match-history/match-history.component';
import { MatTableModule } from '@angular/material/table';
import {MaterialModule} from "./material-module";
import { UserComponent } from './ladder/leaderboard/user/user.component';
import { MatIconModule} from "@angular/material/icon";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";


@NgModule({
  declarations: [
    AppComponent,
    SignInComponent,
    SignUpComponent,
    routingComponent,
    HomePageComponent,
    LadderComponent,
    LandingPageComponent,
    LeaderboardComponent,
    MatchHistoryComponent,
    UserComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        FormsModule,
        ReactiveFormsModule,
        MatTableModule,
        MaterialModule,
        MatIconModule,
        BrowserAnimationsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
