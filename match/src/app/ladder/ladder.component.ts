import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { User } from '../sign-up/sign-up.component';

@Component({
  selector: 'ladder',
  templateUrl: './ladder.component.html',
  styleUrls: ['./ladder.component.css']
})
export class LadderComponent implements OnInit {

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  allLaddersPerUser() {
    let response = this.http.get<Ladder>('http://localhost:8080/ladder/owner/' + localStorage.getItem('owner'))

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
