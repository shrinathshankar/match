import {HttpClient} from "@angular/common/http";
import {BehaviorSubject, Observable} from "rxjs";
import {Injectable} from "@angular/core";


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
}
