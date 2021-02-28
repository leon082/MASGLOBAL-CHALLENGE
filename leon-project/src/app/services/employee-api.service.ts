import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from "@angular/http";
import { map } from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class EmployeeApiService {

  private url: String;

  constructor(private _http: Http) { 
    this.url = "http://localhost:8989/backend.challenge.masglobal";
  }


  getEmployees() {

    const headers = new Headers({
      "Content-Type": "application/json"
    });

    let options = new RequestOptions({ headers: headers });

    return this._http
      .get(
        this.url +
          "/employee/annualSalaries/all",
        options
      )
      .pipe(map((res: Response) => res.json()));
  }

  getEmployeeById(stringId) {

    const headers = new Headers({
      "Content-Type": "application/json"
    });

    let options = new RequestOptions({ headers: headers });

    return this._http
      .get(
        this.url +
          "/employee/annualSalaries/id="+stringId,
        options
      )
      .pipe(map((res: Response) => res.json()));
  }

}
