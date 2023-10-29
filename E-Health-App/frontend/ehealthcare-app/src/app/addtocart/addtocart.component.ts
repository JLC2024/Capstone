import { Component } from '@angular/core';
import { AddtocartService } from '../addtocart.service';
import { CartItem } from '../viewmedicine/cartitem';
import { Router } from '@angular/router';

@Component({
  selector: 'app-addtocart',
  templateUrl: './addtocart.component.html',
  styleUrls: ['./addtocart.component.css']
})
export class AddToCartComponent {
  emailid: string = '';
  mid: number = 0;
  quantity: number = 0;
  msg: string = '';
  cartItems: CartItem[] = []; // Use the CartItem interface for the cart items

  constructor(private addtocartService: AddtocartService, public router:Router) {}

  incrementQuantity(item: CartItem) {
    item.quantity++;
  }

  decrementQuantity(item: CartItem) {
    if (item.quantity > 1) {
      item.quantity--;
    }
  }

  deleteItemFromCart(item: CartItem) {
    const index = this.cartItems.indexOf(item);
    if (index !== -1) {
      this.cartItems.splice(index, 1);
    }
  }

  addToCart() {
    this.addtocartService.addToCart(this.emailid, this.mid, this.quantity).subscribe({
      next: (response) => {
        console.log('Item added to cart: ', response);
        this.msg = 'Item added to cart';
      },
      error: (error) => {
        console.error('Error: ', error);
        this.msg = 'Something went wrong, please try again';
      }
    });
  }
}