import { Component, OnInit } from '@angular/core';
import { MedicineService } from '../medicine.service';
import { Medicine } from '../medicine';

@Component({
  selector: 'app-viewmedicine',
  templateUrl: './viewmedicine.component.html',
  styleUrls: ['./viewmedicine.component.css']
})
export class ViewmedicineComponent implements OnInit {
  medicine:Array<Medicine>=[];
  cart: Array<Medicine>=[];

  constructor(public medicineService:MedicineService){}

    ngOnInit(): void {
        this.medicineService.findAll().subscribe({
          next:(data:any)=>{
            this.medicine=data
          },
          error:(error:any)=>{
            console.log(error)
          },
          complete:()=> {
            console.log("done")
          }
        })
    }

   

    searchByKeyword(searchKeyword: string) {
      if (searchKeyword) {
        this.medicineService.getAllMedicine(searchKeyword).subscribe({
          next: (data: any) => {
            this.medicine = data;
          },
          error: (error: any) => {
            console.log(error);
          }
        });
      } else {
       
        this.medicineService.findAll().subscribe({
          next: (data: any) => {
            this.medicine = data;
          },
          error: (error: any) => {
            console.log(error);
          }
        });
      }
    }
  

    addToCart(medicineItem:Medicine){
      this.cart.push(medicineItem);
    }
}
