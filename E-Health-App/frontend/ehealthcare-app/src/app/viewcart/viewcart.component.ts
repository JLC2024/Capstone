import { Component} from '@angular/core';
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

constructor(router: Router, private viewcartService: ViewcartService, private userService: UserService){}

ngOnInit(): void {
  const emailid = sessionStorage.getItem('emailid') 
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


 incrementQuantity(item: CartItem) {
   item.quantity += 1;
 }

 decrementQuantity(item: CartItem) {
   if (item.quantity > 1) {
     item.quantity -= 1;
   }
 }

 deleteItemFromCart(item: CartItem) {
   delete this.cartItems[item.mid];
 }


cartItemsArray(): CartItem[] {
    return Object.values(this.cartItems);
  }
}
