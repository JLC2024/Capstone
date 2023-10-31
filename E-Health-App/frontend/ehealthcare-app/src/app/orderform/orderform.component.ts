import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { OderformService } from '../orderform.service';
import { ViewcartService } from '../viewcart.service';
import { CartItem } from '../viewmedicine/cartitem';
import { FormGroup,FormControl } from '@angular/forms';
import { Router } from '@angular/router';




@Component({
  selector: 'app-orderform',
  templateUrl: './orderform.component.html',
  styleUrls: ['./orderform.component.css']
})
export class OrderformComponent  implements OnInit{


    medicineName: string = '';
    phoneNumber: string = '';
    address: string = '';
    contactMethod: string = '';
    additionalComments: string = '';
    userEmail: string = '';
  
    constructor(private route: ActivatedRoute, private orderformService: OderformService, private viewcartService: ViewcartService, public router: Router ) {
    this.route.queryParams.subscribe((params) => {
      this.medicineName = params['medicineName'];
    });

  }

  orderRef = new FormGroup({
      medicineName:new FormControl(),
      phoneNumber:new FormControl(),
      address:new FormControl(),
      contactMethod:new FormControl(),
      additionalComments:new FormControl()

     
    });
    

  ngOnInit() {
    this.initializeFormFields();
    console.log('Medicine Name: ', this.medicineName);
  }
  
  initializeFormFields() {
    const emailid = sessionStorage.getItem('emailid');
    if (emailid) {
      this.viewcartService.getCartItems(emailid).subscribe((cartItems: CartItem[]) => {
      console.log(cartItems);
      const userEmail = sessionStorage.getItem('emailid');
       if (userEmail) {
        this.userEmail = userEmail;
        
  } else {
    alert("Error userEmail empty");
  }
      for (const cartItem of cartItems) {
        console.log(`Medication Name: ${cartItem.medrequest.mname}`);
        console.log(`Quantity: ${cartItem.quantity}`);
      }

        if (cartItems.length > 0) {
          this.medicineName = cartItems[0].medrequest.mname;
      }else {
        console.error('Cart is empty'); 
      }
    });

  }else{
    alert ("error proceeding")
  }
 
  }
  submitOrderForm() {
    
   
      const formData = {
        medicineName: this.medicineName,
        phoneNumber: this.phoneNumber,
        address: this.address,
        contactMethod: this.contactMethod,
        additionalComments: this.additionalComments,
      };
      console.log ('submitting form data: ', formData)
      this.orderformService.saveMedicationOrder(formData).subscribe({
        next:(response) => {
        console.log('Form submitted successfully', response);
        window.alert('Form submitted successfully');
        //this.router.navigate(['/payment']);

        },
      error: (error: any) => {
        console.error('Error submitting form:', error);
        alert('There was an error submitting the form. Please try again.');
      }
    });
    
  }
}
