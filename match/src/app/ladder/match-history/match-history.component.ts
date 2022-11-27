import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-match-history',
  templateUrl: './match-history.component.html',
  styleUrls: ['./match-history.component.css']
})
export class MatchHistoryComponent implements OnInit {

  constructor() { }
  @Input() Matches: any;

  displayedColumns = ["Winner", "Team 1", "Team 2", "Team 3"]

  ngOnInit(): void {
  }

}
