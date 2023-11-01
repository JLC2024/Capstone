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
  }


