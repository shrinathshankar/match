import {Component, Inject, ViewChild} from '@angular/core';
import {UntypedFormControl, UntypedFormGroup} from "@angular/forms";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {ApiResolver} from "../../../apiResolver";
import {MatCheckbox} from "@angular/material/checkbox";

@Component({
  selector: 'app-match',
  templateUrl: './match.component.html',
  styleUrls: ['./match.component.css']
})
export class MatchComponent {
  // @ts-ignore
  @ViewChild('one') private team1: MatCheckbox
  // @ts-ignore
  @ViewChild('two') private team2: MatCheckbox

  checked: boolean;
  team1player1: string;
  team1player2: string;
  team2player1: string;
  team2player2: string;
  // team3player1: string;
  // team3player2: string;

  ladderId: any;

  playerForm = new UntypedFormGroup({
    team1player1: new UntypedFormControl(''),
    team1player2: new UntypedFormControl(''),
    team2player1: new UntypedFormControl(''),
    team2player2: new UntypedFormControl(''),
    // team3player1: new UntypedFormControl(''),
    // team3player2: new UntypedFormControl(''),
  });

  constructor(private dialogRef: MatDialogRef<MatchComponent>,
              @Inject(MAT_DIALOG_DATA) data: any,
              private apiResolver: ApiResolver) {
    this.checked = false;
    this.team1player1 = data.desc;
    this.team1player2 = data.desc;
    this.team2player1 = data.desc;
    this.team2player2 = data.desc;
    // this.team3player1 = data.desc;
    // this.team3player2 = data.desc;

    this.ladderId = data.ladderId;
  }

  ngOnInit(): void {

  }

  check(): void {
    this.checked = !this.checked;
  }

  save() {
    let teams = [
      new Team(this.playerForm.get("team2player2")?.value, this.playerForm.get("team2player1")?.value, !this.team1.checked),
      new Team(this.playerForm.get("team1player2")?.value, this.playerForm.get("team1player1")?.value, !this.team2.checked)]

    this.apiResolver.createGameInLadder(new GameRequest(teams, this.ladderId)).subscribe(
      data => {
        if (data === 200) {
          console.log("game created")
          window.location.reload();
        } else {
          console.table(data);
        }
      }
    );

    this.dialogRef.close(this.playerForm.value);
  }

  close() {
    this.dialogRef.close();
  }
}

export class GameRequest {
  teams: any;
  ladderId: any;

  constructor(teams: any, ladderId: any) {
    this.teams = teams;
    this.ladderId = ladderId;
  }
}

export class Team {
  playerOne: any;
  playerTwo: any;
  win: boolean;

  constructor(playerOne: any, playerTwo: any, win: boolean) {
    this.playerOne = playerOne;
    this.playerTwo = playerTwo;
    this.win = win
  }
}

