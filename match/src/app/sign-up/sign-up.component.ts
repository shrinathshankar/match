import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-sign-up',
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

  public signUpEvent() {
    this.http.post('/add', new User(this.username, this.password, this.email))
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
