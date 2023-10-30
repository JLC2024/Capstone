export class CartItem {
  emailid: string;
  customer: any;
  medrequest: {
    mid: number;
    mname: string;
    price: number;
    qty: number;
    imageurl: string;
    description: string;
  };
  quantity: number;

  constructor(emailid: string, medrequest: any, quantity: number) {
    this.emailid = emailid;
    this.medrequest = medrequest;
    this.quantity = quantity;
  }
}