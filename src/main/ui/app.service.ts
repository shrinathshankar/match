import { Injectable } from "./angular/core"
import { HttpClient } from @angular/common/http


@Injectable({
    providedIn: 'root'
})
export class AppService {

    constructor(private http: HttpClient) {}

    playerRoot = '/player'
    teamRoot = 'teams'

    getAllUsers() {
        return this.http.get(this.playerRoot + '/all')
    }

    findSpecificPerson( name: string, username: string) {
        var playerRequest
        playerRequest.name = name;
        playerRequest.username = username;
        return this.http.get(this.playerRoot + '/find', playerRequest)
    }

    addNewPerson(name: string, username: string, password: string) {
        var playerRequest
        playerRequest.name = name;
        playerRequest.username = username;
        playerRequest.password = password;
        return this.http.post(this.playerRoot + '/add', playerRequest)
    }

    createTeam(players: Array<String>) {
        return this.http.post(this.teamRoot + '/create', players)
    }

    resolveGame(teams: Array<team>) {
        return this.http.post(this.teamRoot + '/game', teams)
    }

}