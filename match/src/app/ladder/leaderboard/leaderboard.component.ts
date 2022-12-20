import {Component, Input, OnInit} from '@angular/core';
import Timeout = NodeJS.Timeout;
import {delay} from "rxjs";

@Component({
  selector: 'app-leaderboard',
  templateUrl: './leaderboard.component.html',
  styleUrls: ['./leaderboard.component.css']
})
export class LeaderboardComponent implements OnInit {

  constructor() { }
  @Input() Players: any;

  displayedColumns = ["Name", "Win/Loss", "Rating"]

  ngOnInit(): void {

  }


  toggle(e: HTMLElement) {
    e.classList.toggle('hidden');
  }

}
