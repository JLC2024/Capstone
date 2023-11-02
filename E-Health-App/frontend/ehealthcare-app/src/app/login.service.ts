import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Login } from './login';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(public http:HttpClient) { }

  baseUrl:string="http://13.52.231.145:9090/login"

  signIn(login:any):Observable<string> {
    return this.http.post(this.baseUrl+"/signIn",login,{responseType:'text'});
  }

  signUp(login:any):Observable<string> {
    return this.http.post(this.baseUrl+"/signUp",login,{responseType:'text'});
  }
}
