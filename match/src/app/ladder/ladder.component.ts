import {HttpClient} from '@angular/common/http';
import {Component, OnInit} from '@angular/core';
import {User} from '../sign-up/sign-up.component';

@Component({
  selector: 'ladder',
  templateUrl: './ladder.component.html',
  styleUrls: ['./ladder.component.css']
})
export class LadderComponent implements OnInit {

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  getHtmlLadderList() {
    let ladderList = this.allLaddersPerUser();
    let ladders = "";
    for (ladder of ladderList) {

    }
  }

  allLaddersPerUser(): Array<Ladder> {
    try {
      let response = fetch('http://localhost:8080/ladder/owner/' + localStorage.getItem('owner'),{
        method: 'GET',
        headers: {
          'Content-Type': 'application/json',
        }
      });
      response.then(response => {
        if (!response.ok) {
          throw new Error(`HTTP error! Status: ${ response.status }`)
        }

        return response.blob()
      }).then(response => {
        response.
      })

    } catch (error) {
      console.log(error);
    }
    return null;
  }

}

export class Ladder {
  owner: User
  players: Array<Player>
  matches: Array<Match>
  id: number
  constructor(owner: User, player: Array<Player>, matches: Array<Match>, id: number) {
    this.owner = owner
    this.matches = matches
    this.players = player
    this.id = id
  }
}

export class Player {
  name: string
  rating: number
  id: number
  constructor(name: string, rating: number, id: number) {
    this.name = name;
    this.rating = rating
    this.id = id
  }
}

export class Team {
  playerOne: Player
  playerTwo: Player
  id: number
  constructor(playerOne: Player, playerTwo: Player, id: number) {
    this.playerOne = playerOne
    this.playerTwo = playerTwo
    this.id = id
  }
}

export class Match {
  teams: Array<Team>
  id: number
  constructor(teams: Array<Team>, id: number) {
    this.teams = teams
    this.id = id
  }
}
