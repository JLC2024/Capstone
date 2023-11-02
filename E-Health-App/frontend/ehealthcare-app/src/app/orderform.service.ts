import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OderformService {
  baseUrl:string="http://13.52.231.145/orders";
  constructor(private http: HttpClient) { }

  saveMedicationOrder(medicationOrder: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/submit`, medicationOrder);
  }

  deleteCartItem(emailid: string, mid: number): Observable<void> {
    return this.http.delete<void>(`http://13.52.231.145/cart/${emailid}/${mid}`);
  }
}
