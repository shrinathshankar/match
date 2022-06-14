import {HttpClient} from '@angular/common/http';
import {Component, OnInit} from '@angular/core';
import {User} from '../sign-up/sign-up.component';
import * as http from "http";

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
    for ( let ladder in  ladderList) {
      ladders+="<li> " + ladder + "</li>"
    }
  }

  allLaddersPerUser(): Array<Ladder> {
    let laddersPerOwner = new Array<Ladder>();
    try {
      let response = this.http.get<Array<Ladder>>('http://localhost:8080/ladder/owner/' + localStorage.getItem('owner'))
      response.subscribe(ladders => {
        ladders.map(ladder => laddersPerOwner.push(ladder))
      })

    } catch (error) {
      console.log(error);
    }
    return laddersPerOwner;
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
