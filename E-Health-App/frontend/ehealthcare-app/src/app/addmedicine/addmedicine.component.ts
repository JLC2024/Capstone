import { Component,OnInit } from '@angular/core';
import { MedicineService } from '../medicine.service';
import { FormControl, FormGroup } from '@angular/forms';
import { Medicine } from '../medicine';


@Component({
  selector: 'app-addmedicine',
  templateUrl: './addmedicine.component.html',
  styleUrls: ['./addmedicine.component.css']
})
export class AddmedicineComponent implements OnInit{

  medicineRef = new FormGroup({
    mid: new FormControl(),
    mname:new FormControl(),
    price:new FormControl(),
    qty:new FormControl(),
    imageurl:new FormControl(),
    description:new FormControl()
  });

  updateMedicineRef = new FormGroup({
    mname: new FormControl(),
    price: new FormControl(),
    qty: new FormControl(),
    imageurl: new FormControl(),
    description: new FormControl()
  });

  msg:string="";
  medicine:Array<Medicine>=[];
  updatedMedicine:Medicine = new Medicine();

  selectedMedicine: Medicine| null = null;
  showUpdateForm: boolean = false;
  buttonName:string="Store Medicine";

  constructor(public medicineService:MedicineService){
   
  }


  storeMedicine(){
    let medicine= this.medicineRef.value;
    this.medicineService.storeMedicine(medicine).subscribe({
      next:(result:any)=> {
          this.msg=result;
      },
      error:(error:any)=> {
        this.msg = error;
        console.log(error)
      },
      complete:()=> {
        console.log("done!")
      }
    })

    this.medicineRef.reset();
    this.refreshMedicineList();

  }
  

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

refreshMedicineList(){
  this.medicineService.findAll().subscribe({
    next:(data:any)=>{
      this.medicine=data
    },
    error:(error:any)=>{
      console.log(error)
    },
      complete:()=>{
      console.log('Medicine list refreshed');
    }
});
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

}
  
  
  