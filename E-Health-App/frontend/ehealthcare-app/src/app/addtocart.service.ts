import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class AddtocartService {

  baseUrl:string="http://localhost:9090/cart";

  constructor(private http: HttpClient) { }

  addToCart(emailid: string, mid: number, quantity: number) {
    const data = { emailid, mid, quantity };

    return this.http.post(`${this.baseUrl}/add`, data, { responseType: 'text' });
  }
  }
