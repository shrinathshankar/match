import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {UntypedFormControl, UntypedFormGroup} from "@angular/forms";
import { Router } from '@angular/router';

@Component({
  selector: 'signIn',
  templateUrl: './sign-in.component.html',
  styles: [
  ]
})
export class SignInComponent implements OnInit {

  private signInResponse = new SignInResponse(false)

  userForm = new UntypedFormGroup({
    username: new UntypedFormControl(''),
    password: new UntypedFormControl('')
  });

  constructor(private http: HttpClient, private router: Router) { }

  ngOnInit(): void {
  }

  signUpEvent() {
    let user = new User(this.userForm.get('username')?.value, this.userForm.get('password')?.value, '')
    let response = this.http.post<SignInResponse>('http://localhost:8080/user/validate', user)
    response.subscribe(value => console.log(value))
    response.subscribe(value => this.signInResponse = new SignInResponse(value.success))
    if (this.signInResponse.success) {
      localStorage.setItem("userId", user.id)
      this.router.navigate(['/home'])
    }
    //otherwise sent bad input material design
  }
}

export class User {
  username: string
  password: string
  id: string
  constructor(username: string, password: string, id: string) {
    this.username = username;
    this.password = password
    this.id = id
  }

}

export class SignInResponse {
  get success(): boolean {
    return this._success;
  }
  private _success: boolean
  constructor(success: boolean) {
    this._success = success
  }
}

