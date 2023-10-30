import { Component } from '@angular/core';
import { AddtocartService } from '../addtocart.service';
import { CartItem } from '../viewmedicine/cartitem';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

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
  cartItems!: any[];

  constructor(private addtocartService: AddtocartService, public router:Router) {}

  incrementQuantity(item: CartItem) {
    item.quantity += 1;
  }
  
  decrementQuantity(item: CartItem) {
    if (item.quantity > 1) {
      item.quantity -= 1;
    }
  }
  
  deleteItemFromCart(item: CartItem) {
    delete this.cartItems[item.medrequest.mid];
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
  cartItemsArray(): CartItem[] {
    return Object.values(this.cartItems);
  }
  }