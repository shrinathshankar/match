import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'signIn',
  templateUrl: './sign-in.component.html',
  styles: [
  ]
})
export class SignInComponent implements OnInit {

  private signInResponse = new SignInResponse(false)

  userForm = new FormGroup({
    username: new FormControl(''),
    password: new FormControl('')
  });

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  signUpEvent() {
    let user = new User(this.userForm.get('username')?.value, this.userForm.get('password')?.value)
    let response = this.http.post<SignInResponse>('http://localhost:8080/user/validate', user)
    response.subscribe(value => console.log(value))
    response.subscribe(value => this.signInResponse = new SignInResponse(value.success))
    if (this.signInResponse) {

    }
  }
}

export class User {
  username: string
  password: string
  constructor(username: string, password: string) {
    this.username = username;
    this.password = password
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

