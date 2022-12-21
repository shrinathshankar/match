import {Component, Input, OnInit} from '@angular/core';
import Timeout = NodeJS.Timeout;
import {delay} from "rxjs";
import {MatDialog, MatDialogConfig} from "@angular/material/dialog";
import {UserComponent} from "./user/user.component";

@Component({
  selector: 'app-leaderboard',
  templateUrl: './leaderboard.component.html',
  styleUrls: ['./leaderboard.component.css']
})
export class LeaderboardComponent implements OnInit {

  constructor(private dialog: MatDialog) { }
  @Input() Players: any;

  displayedColumns = ["Name", "Win/Loss", "Rating"]

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
      desc: ""
    }
    dialogConfig.maxWidth = "500px";
    this.dialog.open(UserComponent, dialogConfig);
  }
}
