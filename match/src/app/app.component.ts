import { Component } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'match';

  constructor(public router: Router) {
  }

  goToPage(page:string):void {
    this.router.navigate([`${page}`]);
  }
}
