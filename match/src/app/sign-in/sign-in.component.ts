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

  private signInResponse = false

  userForm = new UntypedFormGroup({
    username: new UntypedFormControl(''),
    password: new UntypedFormControl('')
  });

  constructor(private http: HttpClient, private router: Router) { }

  ngOnInit(): void {
  }

  signUpEvent() {
    let user = new User(this.userForm.get('username')?.value, this.userForm.get('password')?.value, '')
    let response = this.http.post<any>('http://localhost:8080/user/validate', user)
    response.subscribe(value => {
      this.signInResponse = value.success;
        localStorage.setItem("userId", value.ownerId);
        localStorage.setItem("username", user.username)
      if (value.success) {
        this.router.navigate(['/home'])

      }
      }
    )
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



