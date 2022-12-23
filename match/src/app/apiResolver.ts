import {HttpClient} from "@angular/common/http";
import {BehaviorSubject, Observable} from "rxjs";
import {Injectable} from "@angular/core";
import {CreatePlayer} from "./ladder/leaderboard/user/user.component";
import {LadderRequest} from "./ladder/create-ladder/create-ladder.component";


@Injectable({
  providedIn: 'root'
})
export class ApiResolver {
  private apiData = new BehaviorSubject<any>(null);
  constructor(private http: HttpClient) {
  }

  getLaddersPerUser(): Observable<any> {
    return this.http.get('http://localhost:8080/ladder/owner/' + localStorage.getItem('userId'));
  }

  setData(data: any) {
    this.apiData.next(data);
  }

  createPlayerInLadder(name: string, ladderId: string) : Observable<any> {
    let player = new CreatePlayer(name, ladderId);
    return this.http.post<any>('http://localhost:8080/player/add/ladder', player)
  }

  createGameInLadder(data: any) : Observable<any> {
    console.table(data);
    return this.http.post<any>('http://localhost:8080/match/add', data);
  }

  createLadder(request: LadderRequest): Observable<any> {
    return this.http.post('http://localhost:8080/ladder/create', request);
  }
}
