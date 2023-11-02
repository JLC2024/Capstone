import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CartItem } from './viewmedicine/cartitem';

@Injectable({
  providedIn: 'root'
})

export class AddtocartService {

  baseUrl:string="http://13.52.231.145/cart";

  constructor(private http: HttpClient) { }

  
  addToCart(emailid: string, mid: number, quantity: number) {
    const data = { emailid, mid, quantity };
    console.log("email id used: ", emailid)
    return this.http.post(`${this.baseUrl}/add`, data,  {responseType: 'text'});
  }
  }
