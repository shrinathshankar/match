import {HttpClient} from '@angular/common/http';
import {Component, Input, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {ApiResolver} from "../apiResolver";
import {MatDialog, MatDialogConfig} from "@angular/material/dialog";
import {UserComponent} from "./leaderboard/user/user.component";
import {CreateLadderComponent} from "./create-ladder/create-ladder.component";

@Component({
  selector: 'ladder',
  templateUrl: './ladder.component.html',
  styleUrls: ['./ladder.component.css']
})
export class LadderComponent implements OnInit {
  @Input()
  LadderList: any;

  displayedColumns = ["Rank", "Name", "Win/Loss", "Rating"]


  constructor(private dialog: MatDialog) {
  }

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
    }
    dialogConfig.maxWidth = "500px";
    this.dialog.open(CreateLadderComponent, dialogConfig);
  }

}



