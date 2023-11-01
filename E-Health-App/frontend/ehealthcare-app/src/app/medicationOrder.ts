export class MedicationOrder {
    id: number;
    medicineName: string;
    price: string;
    quantity: number;
    fullName: string;
    phoneNumber: string;
    address: string;
    contactMethod: string;
    additionalComments: string;
    approved: boolean;
  
    constructor(
      id: number,
      medicineName: string,
      price: string,
      quantity: number,
      fullName: string,
      phoneNumber: string,
      address: string,
      contactMethod: string,
      additionalComments: string,
      approved: boolean
    ) {
      this.id = id;
      this.medicineName = medicineName;
      this.price = price;
      this.quantity = quantity;
      this.fullName = fullName;
      this.phoneNumber = phoneNumber;
      this.address = address;
      this.contactMethod = contactMethod;
      this.additionalComments = additionalComments;
      this.approved = approved;
    }
  }