import { Component, OnInit } from '@angular/core';
import { MedicineService } from '../medicine.service';
import { Medicine } from '../medicine';
import { FormControl, FormGroup } from '@angular/forms';
import { Validators } from '@angular/forms';



@Component({
  selector: 'app-updatemedicine',
  templateUrl: './updatemedicine.component.html',
  styleUrls: ['./updatemedicine.component.css']
})
export class UpdatemedicineComponent implements OnInit{

  updateMedicineRef: FormGroup;
  medicine: Medicine[] = [];
  updatedMedicine:Medicine = new Medicine();
  selectedMedicine: Medicine| null = null;
  showUpdateForm: boolean = false;


  constructor(public medicineService: MedicineService) {
    this.updateMedicineRef = new FormGroup({
      mname: new FormControl('', Validators.required), // Add validators as needed
      price: new FormControl('', Validators.required),
      qty: new FormControl('', Validators.required),
      imageurl: new FormControl('', Validators.required), 
      description: new FormControl('', Validators.required),
    });
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

    showUpdateFormForMedicine(medicine: Medicine) {
      this.selectedMedicine = medicine;
      this.updateMedicineRef.patchValue({
        mname: medicine.mname,
        price: medicine.price,
        qty: medicine.qty,
        imageurl: medicine.imageurl,
        description: medicine.description,
      });

      console.log('selectedMedicine:', this.selectedMedicine);
    console.log('updateMedicineRef:', this.updateMedicineRef.value);
      this.showUpdateForm = true;
    }
    
    updateMedicine() {
      if (!this.selectedMedicine) {
        // Handle the case where selectedMedicine is not defined
        // For example, show an error message or return early
        console.error('selectedMedicine is undefined');
        return;
      }
    
      const updatedMedicine: Medicine = {
        mid: this.selectedMedicine.mid,
        mname: this.updateMedicineRef.get('mname')?.value,
        price: this.updateMedicineRef.get('price')?.value,
        qty: this.updateMedicineRef.get('qty')?.value,
        imageurl: this.updateMedicineRef.get('imageurl')?.value,
        description: this.updateMedicineRef.get('description')?.value
      };
    
      this.medicineService.updateMedicine(this.selectedMedicine.mid,updatedMedicine).subscribe(
        (response: Medicine) => {
          // Handle the response
          console.log('Medicine updated successfully:', response);
          // Optionally reset the form or close the update form
          this.showUpdateForm = false;
          this.updateMedicineRef.reset();
        },
        (error) => {
          // Handle errors, e.g., display an error message
          console.log('Error updating medicine:', error);
        }
      );
      }

      deleteMedicine(mid: number) {
        this.medicineService.deleteMedicine(mid).subscribe( data => {
          console.log(data);
          this.refreshMedicineList();
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
    
    
        
