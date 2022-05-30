import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SignUpComponent } from './sign-up/sign-up.component'
import { SignInComponent } from "./sign-in/sign-in.component";

const routes: Routes = [
  {path: 'signUp', component: SignUpComponent},
  {path: 'signIn', component: SignInComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponent = [SignUpComponent, SignInComponent]
