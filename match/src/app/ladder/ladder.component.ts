import {HttpClient} from '@angular/common/http';
import {Component, Input, OnInit} from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'ladder',
  templateUrl: './ladder.component.html',
  styleUrls: ['./ladder.component.css']
})
export class LadderComponent implements OnInit {
  @Input()
  LadderList: any;

  displayedColumns = ["Rank", "Name", "Win/Loss", "Rating"]


  constructor() {
  }

  ngOnInit(): void {

  }

  toggle(e: HTMLElement) {
    e.classList.toggle('hidden');
  }
}

