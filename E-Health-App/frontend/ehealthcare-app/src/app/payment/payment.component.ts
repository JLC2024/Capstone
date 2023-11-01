import { Component, OnInit } from '@angular/core';
import { render } from 'creditcardpayments/creditCardPayments';
import { Router } from '@angular/router';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent {

  constructor(private router: Router) {
    render(
      {
        id: "#myPayPalButtons",
        currency: "USD",
        value: "20.00",
        onApprove: (details)=>{
            alert("transaction awaiting approval")
        }
      }
    )


  }

}
