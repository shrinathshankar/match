import {HttpClient} from "@angular/common/http";
import {BehaviorSubject, Observable} from "rxjs";
import {Injectable} from "@angular/core";
import {CreatePlayer} from "./ladder/leaderboard/user/user.component";


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
}
