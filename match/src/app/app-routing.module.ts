import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SignUpComponent } from './sign-up/sign-up.component'
import { SignInComponent } from "./sign-in/sign-in.component";
import { LadderComponent } from './ladder/ladder.component';
import { HomePageComponent } from './home-page/home-page.component';
import {LandingPageComponent} from "./landing-page/landing-page.component";


const routes: Routes = [
  {path: 'signUp', component: SignUpComponent},
  {path: 'signIn', component: SignInComponent},
  {path: 'ladder', component: LadderComponent},
  {path: 'home', component: HomePageComponent},
  {path: '', component: LandingPageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponent = [SignUpComponent, SignInComponent, LadderComponent, HomePageComponent, LandingPageComponent]
