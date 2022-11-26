import {HttpClient} from '@angular/common/http';
import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'ladder',
  templateUrl: './ladder.component.html',
  styleUrls: ['./ladder.component.css']
})
export class LadderComponent implements OnInit {
  LadderList: any;

  displayedColumns = ["Rank", "Name", "Win/Loss", "Rating"]

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.LadderList = this.allLaddersPerUser()
  }

  allLaddersPerUser() {
    let laddersPerOwner;
    try {
      let response = this.http.get('http://localhost:8080/ladder/owner/' + localStorage.getItem('owner'))
      response.subscribe(data => {
        laddersPerOwner = data;
      })

    } catch (error) {
      console.log(error);
    }
    return laddersPerOwner;
  }

}

