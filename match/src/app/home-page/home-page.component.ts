import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {Observable} from "rxjs";
import {ApiResolver} from "../apiResolver";

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  loadChild: any;
  ladders: any;

  constructor(private apiResolver: ApiResolver, private router: Router) { }

  ngOnInit(): void {
    console.log("init")
    this.ladders = this.allLaddersPerUser()
    console.log("complete")
  }

  allLaddersPerUser() {
    this.apiResolver.getLaddersPerUser().subscribe(
      res => {
        this.ladders = res;
        console.log("ladders")
        console.table(this.ladders)
      }
    )
  }



  setLoadChild() {
    this.loadChild = true;
    this.ladders = this.allLaddersPerUser()
  }
}
