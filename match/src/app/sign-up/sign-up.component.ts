import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'signUp',
  templateUrl: './sign-up.component.html',
  styles: [
  ]
})
export class SignUpComponent implements OnInit {

  username: string = '';
  password: string = '';
  email: string = '';

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
  }

  signUpEvent() {
    this.http.post('/user/add', new User(this.username, this.password, this.email))
  }
}

export class User {
  constructor(
    username: string,
    password: string,
    email: string
  ) {
  }
}
