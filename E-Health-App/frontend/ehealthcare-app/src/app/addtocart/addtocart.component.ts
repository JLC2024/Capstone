import { Component } from '@angular/core';
import { AddtocartService } from '../addtocart.service';

@Component({
  selector: 'app-addtocart',
  templateUrl: './addtocart.component.html',
  styleUrls: ['./addtocart.component.css']
})
export class AddToCartComponent { 
  emailid: string ='';
  mid: number = 0;
  quantity: number = 0;
  msg: string = "";

  constructor(private addtocartService: AddtocartService) { }

  addToCart() {
    this.addtocartService.addToCart(this.emailid, this.mid, this.quantity).subscribe({
      next:(response) => {
        console.log('Item added to cart: ', response);
        this.msg = "Item added to cart"; 
      },
      error:(error) => {
        console.error('Error: ', error);
        this.msg = "Something went wrong, please try again"; 
      }
  });
  }
}
