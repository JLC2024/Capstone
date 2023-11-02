import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Medicine } from './medicine';


@Injectable({
  providedIn: 'root'
})
export class MedicineService {
  baseUrl:string = "http://13.52.231.145/medicine"

  constructor(public http:HttpClient) { }

  storeMedicine(medicine:any):Observable<string>{
    return this.http.post(this.baseUrl+"/store",medicine,{responseType:'text'});
  }

  findAll():Observable<Medicine[]>{
    return this.http.get<Medicine[]>(this.baseUrl+"/findAll");
  }
  
  getAllMedicine(searchKeyword: string): Observable<Medicine[]> {
    return this.http.get<Medicine[]>(this.baseUrl + "/search?searchKey=" + searchKeyword);
  }
  
  deleteMedicine(mid:number):Observable<any>{
    return this.http.delete(`${this.baseUrl}/${mid}`);
  }

  updateMedicine(id: number, medicine: Medicine): Observable<any> {
    return this.http.put<Medicine>(`${this.baseUrl}/${id}`, medicine);

  
  }
  refreshMedicineList(): Observable<Medicine[]> {
    return this.findAll();
  }
  getMedicineById(mid: number): Observable<Medicine> {
    return this.http.get<Medicine>(`${this.baseUrl}/${mid}`);
  }
  
  
}
