import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { AdmindashboardComponent } from './admindashboard/admindashboard.component';
import { CustomerdashboardComponent } from './customerdashboard/customerdashboard.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { AddmedicineComponent } from './addmedicine/addmedicine.component';
import { ViewmedicineComponent } from './viewmedicine/viewmedicine.component';
import { UpdatemedicineComponent } from './updatemedicine/updatemedicine.component';
import { DeletemedicineComponent } from './deletemedicine/deletemedicine.component';
import { AddToCartComponent } from './addtocart/addtocart.component';
import { ViewcartComponent } from './viewcart/viewcart.component';
import { OrderformComponent } from './orderform/orderform.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    AdmindashboardComponent,
    CustomerdashboardComponent,
    AddmedicineComponent,
    ViewmedicineComponent,
    UpdatemedicineComponent,
    DeletemedicineComponent,
    AddToCartComponent,
    ViewcartComponent,
    OrderformComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule, 
    FormsModule, 
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
