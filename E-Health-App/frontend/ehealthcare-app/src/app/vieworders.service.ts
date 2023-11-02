import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Vieworders } from './vieworders';
import { HttpClient } from '@angular/common/http';
import { MedicationOrder } from './medicationOrder';


@Injectable({
  providedIn: 'root'
})
export class ViewordersService {
  baseUrl:string="http://13.52.231.145/orders";

  constructor(private http: HttpClient) { }

  getMedicationOrders(): Observable<MedicationOrder[]> {
    return this.http.get<MedicationOrder[]>(`${this.baseUrl}/list`);
  }

  deleteMedicationOrder(orderId: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/delete/${orderId}`);
  }
}
