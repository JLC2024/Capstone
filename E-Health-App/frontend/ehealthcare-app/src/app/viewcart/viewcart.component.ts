import { Component, Output, EventEmitter } from '@angular/core';
import { Router } from '@angular/router';
import { ViewcartService } from '../viewcart.service';
import { CartItem } from '../viewmedicine/cartitem';
import { UserService } from './userService';






@Component({
  selector: 'app-viewcart',
  templateUrl: './viewcart.component.html',
  styleUrls: ['./viewcart.component.css']
})
export class ViewcartComponent {
  cartItems: CartItem[] = [];

  constructor(router: Router, private viewcartService: ViewcartService, private userService: UserService) {}
 
  transformDataToCartItems(data: any): CartItem[] {
    if (!Array.isArray(data)) {
      
      const cartItem = {
        emailid: data.emailid,
        customer: data.customer,
        medrequest: data.medrequest,
        mid:data.medrequest.mid,
        imageurl: data.medrequest.imageurl,
        mname: data.medrequest.mname,
        price: data.medrequest.price,
        qty: data.medrequest.qty, 
        quantity: 1, 
        description: data.description
      };
      console.log('Transformed data for a single item:', [cartItem]);
    
      return [cartItem];
    } else {
      const transformedData = data.map((item: any) => {
        return {
          emailid: item.emailid,
          customer: item.customer,
          medrequest: item.medrequest,
          mid: item.medrequest.mid,
          imageurl: item.medrequest.imageurl,
          mname: item.medrequest.mname,
          price: item.medrequest.price,
          qty: item.medrequest.qty, 
          quantity: 1, 
          description: item.medrequest.description
        };
      });
      console.log('Transformed data for multiple items:', transformedData);
      return transformedData;
    }
  }
    


  ngOnInit(): void {
    const emailid = sessionStorage.getItem('emailid');
    if (emailid) {
      this.loadCartItems(emailid);
    }
  }
  

  loadCartItems(emailid: string): void {
    if (emailid) {
      this.viewcartService.getCartItems(emailid).subscribe({
        next: (items: CartItem[]) => {
          if (items) {
            this.cartItems = items;
            console.log("Received cart items:", this.cartItems);
          } else {
            console.log("No cart items received.");
          }
        },
        error: (error) => {
          console.error('Error loading cart items:', error);
        },
        complete: () => {
          console.log('Cart items retrieval completed.');
        }
      });
    } else {
      console.log('No email provided.');
    }
  }

   
  
   updateQuantity(item: CartItem) {
     if (item.quantity > 0) {
     this.viewcartService.updateCartItemQuantity(item.emailid, item.medrequest.mid, item.quantity).subscribe({
       next: (response) => {
         console.log('Item quantity updated:', response);
       },
       error: (error) => {
         console.error('Error updating item quantity:', error);
       }
     });
   }

 }

  incrementQuantity(item: CartItem) {
    item.quantity += 1;
    this.updateQuantity(item);
  }

  decrementQuantity(item: CartItem) {
    if (item.quantity > 1) {
      item.quantity -= 1;
      this.updateQuantity(item);
    }
  }

  deleteItemFromCart(item: CartItem) {
    this.viewcartService.deleteCartItem(item.emailid, item.medrequest.mid).subscribe({
      next: () => {
      
        const index = this.cartItems.indexOf(item);
        if (index > -1) {
          this.cartItems.splice(index, 1);
        }
      },
      error: (error) => {
        console.error('Error deleting cart item:', error);
      }
  });
}
}

