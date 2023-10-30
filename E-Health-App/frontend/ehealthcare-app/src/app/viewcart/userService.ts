import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private emailid!: string;

  getEmailid(): string {
    return this.emailid;
  }

  setEmailid(emailid: string): void {
    this.emailid = emailid;
  }
}