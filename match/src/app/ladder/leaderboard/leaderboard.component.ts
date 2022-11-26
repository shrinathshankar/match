import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-leaderboard',
  templateUrl: './leaderboard.component.html',
  styleUrls: ['./leaderboard.component.css']
})
export class LeaderboardComponent implements OnInit {

  constructor() { }
  @Input() Ladder: any;

  displayedColumns = ["Rank", "Name", "Win/Loss", "Rating"]

  ngOnInit(): void {
  }

}
