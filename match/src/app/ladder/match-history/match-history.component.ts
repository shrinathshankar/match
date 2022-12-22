import {Component, Input, OnInit} from '@angular/core';
import {MatDialog, MatDialogConfig} from "@angular/material/dialog";
import {UserComponent} from "../leaderboard/user/user.component";
import {MatchComponent} from "./match/match.component";

@Component({
  selector: 'app-match-history',
  templateUrl: './match-history.component.html',
  styleUrls: ['./match-history.component.css']
})
export class MatchHistoryComponent implements OnInit {

  constructor(private dialog: MatDialog) { }
  @Input() Matches: any;
  @Input() ladderId: any;

  displayedColumns = ["Winner", "Team 1", "Team 2"]

  ngOnInit(): void {
  }

  toggle(e: HTMLElement) {
    e.classList.toggle('hidden');
  }

  openDialog() {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.data = {
      desc: "",
      ladderId: this.ladderId
    }
    dialogConfig.maxWidth = "500px";
    this.dialog.open(MatchComponent, dialogConfig);
  }
}
