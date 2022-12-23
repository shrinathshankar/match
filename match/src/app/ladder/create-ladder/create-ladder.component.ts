import {Component, Inject} from '@angular/core';
import {ApiResolver} from "../../apiResolver";
import {UntypedFormControl, UntypedFormGroup} from "@angular/forms";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";

@Component({
  selector: 'app-create-ladder',
  templateUrl: './create-ladder.component.html',
  styleUrls: ['./create-ladder.component.css']
})
export class CreateLadderComponent {

  ladderForm = new UntypedFormGroup({
    name: new UntypedFormControl('')
  });

  constructor(private dialogRef: MatDialogRef<CreateLadderComponent>,
              @Inject(MAT_DIALOG_DATA) data: any,
              private apiResolver: ApiResolver) {
  }

  createLadder() {
    // @ts-ignore
    let request = new LadderRequest(this.ladderForm.get('name')?.value, localStorage.getItem("username"));
    this.apiResolver.createLadder(request).subscribe(value => {
      if (value === 200) {
        console.log("player created")
        window.location.reload();
      } else {
        console.table(value);
      }
    });
  }

  close() {
    this.dialogRef.close();
  }

}
export class LadderRequest {
  name: string;
  username: string;

  constructor(name: string, username: string) {
    this.name = name;
    this.username = username;

  }

}

