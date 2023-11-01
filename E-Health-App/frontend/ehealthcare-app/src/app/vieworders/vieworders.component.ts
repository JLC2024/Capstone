import { Component, OnInit } from '@angular/core';
import { ViewordersService } from '../vieworders.service';
import { MedicationOrder } from '../medicationOrder';

@Component({
  selector: 'app-vieworders',
  templateUrl: './vieworders.component.html',
  styleUrls: ['./vieworders.component.css']
})
export class ViewordersComponent implements OnInit {
  orders: MedicationOrder[] = [];



  constructor(private viewordersService: ViewordersService){}

  ngOnInit(){
    this.viewordersService.getMedicationOrders().subscribe((orders)=>{
      this.orders = orders;
    });
  }
  deleteOrder(orderId: number) {
    if (confirm('Are you sure you want to delete this order?')) {
      this.viewordersService.deleteMedicationOrder(orderId).subscribe(() => {
        // Handle success, e.g., refresh the order list
        this.loadOrders();
      });
    }
  }
  loadOrders() {
    this.viewordersService.getMedicationOrders().subscribe((orders) => {
      this.orders = orders;
    })
  }

}
