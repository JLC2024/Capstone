import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CartItem } from './viewmedicine/cartitem';
import { Viewcart } from './viewcart';
import { LoginService } from './login.service';
import { map } from 'rxjs/operators';



@Injectable({
  providedIn: 'root'
})
export class ViewcartService {
  baseUrl:string="http://13.52.231.145/cart";

  constructor(private http: HttpClient) { }
 
  
  
  getCartItems(emailid: string): Observable<CartItem[]> {
    return this.http.get<CartItem[]>(`${this.baseUrl}/${emailid}`).pipe(
      map((data: any) => {
        if (Array.isArray(data)) {
          return data;
        } else {
         
          return [data];
        }
      })
    );
  }
  updateCartItemQuantity(emailid: string, mid: number, newQuantity: number): Observable<CartItem> {
    const requestBody = { quantity: newQuantity };
    return this.http.put<CartItem>(`${this.baseUrl}/${emailid}/${mid}`, requestBody);
  }

   deleteCartItem(emailid: string, mid: number): Observable<void> {
  return this.http.delete<void>(`${this.baseUrl}/${emailid}/${mid}`);
}
}


