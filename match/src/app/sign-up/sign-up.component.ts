import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {User} from "../sign-in/sign-in.component";
import {Router} from "@angular/router";

@Component({
  selector: 'signUp',
  templateUrl: './sign-up.component.html',
  styles: [
  ]
})
export class SignUpComponent implements OnInit {

  private signInResponse = false

  username: string = '';
  password: string = '';
  email: string = '';

  constructor(private http: HttpClient, private router: Router) {}

  ngOnInit(): void {
  }

  signUpEvent() {
    let user = new User(this.username, this.password, '')
    let response = this.http.post<any>('http://localhost:8080/user/add', new User(this.username, this.password, this.email))
    response.subscribe(value => this.signInResponse =value.success)
    if (this.signInResponse) {
      localStorage.setItem("userId", user.id)
      this.router.navigate(['/home'])
    }
  }
}
