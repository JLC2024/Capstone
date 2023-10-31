import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OderformService {
  baseUrl:string="http://localhost:9090/orders";
  constructor(private http: HttpClient) { }

  saveMedicationOrder(medicationOrder: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/submit`, medicationOrder);
  }
}
