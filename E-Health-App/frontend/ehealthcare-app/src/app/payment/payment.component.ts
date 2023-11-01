// import { Component, AfterViewInit } from '@angular/core';


// @Component({
//   selector: 'app-payment',
//   templateUrl: './payment.component.html',
//   styleUrls: ['./payment.component.css']
// })
// export class PaymentComponent implements AfterViewInit {
//   ngAfterViewInit(): void {
//     if (window.paypal) {
//       // Render PayPal buttons
//       window.paypal.Buttons({
//         // Set the options for your PayPal buttons here
//       }).render('#myPayPalButtons');
//     } else {
//       // Handle the case when the PayPal SDK is not yet loaded
//     }
//   }
// }
  
import { Component, AfterViewInit } from '@angular/core';

declare var paypal: any; // Declare the PayPal variable

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements AfterViewInit {
  ngAfterViewInit(): void {
    if (paypal) {
      // Render PayPal buttons
      paypal.Buttons({
        // Set the options for your PayPal buttons here
        createOrder: function(data: any, actions: any) {
          return actions.order.create({
            purchase_units: [
              {
                amount: {
                  currency_code: 'USD',
                  value: '0.01', // Set to a low value for authorization only
                },
              },
            ],
          });
        },
        onApprove: function(data: any, actions: any) {
          // Handle the approval action, e.g., redirect to PayPal login
          return actions.order.capture().then(function(details: any) {
            // Handle order capture success
            alert('Transaction completed by ' + details.payer.name.given_name);
          });
        },
      }).render('#myPayPalButtons');
    } else {
      // Handle the case when the PayPal SDK is not yet loaded
    }
  }
}

