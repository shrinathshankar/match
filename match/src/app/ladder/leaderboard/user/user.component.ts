import {Component, Inject, Input, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, UntypedFormControl, UntypedFormGroup} from "@angular/forms";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {ApiResolver} from "../../../apiResolver";
import {User} from "../../../sign-in/sign-in.component";

@Component({
  selector: 'app-user-component',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit{
  name: string;
  ladderId: any;

  playerForm = new UntypedFormGroup({
    name: new UntypedFormControl('')
  });

  constructor(private dialogRef: MatDialogRef<UserComponent>,
              @Inject(MAT_DIALOG_DATA) data: any,
              private apiResolver: ApiResolver) {
    this.name = data.desc;
    this.ladderId = data.ladderId;
  }

  ngOnInit(): void {

  }

  save() {
    this.apiResolver.createPlayerInLadder(this.playerForm.get('name')?.value, this.ladderId).subscribe(
      data => {
        if (data === 200) {
          console.log("player created")
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

export class CreatePlayer {
  name: string
  ladderId: string
  constructor(name: string, ladderId: string) {
    this.name = name;
    this.ladderId = ladderId;
  }

}
