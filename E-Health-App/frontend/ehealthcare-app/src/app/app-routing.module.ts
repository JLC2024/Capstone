import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { AdmindashboardComponent } from './admindashboard/admindashboard.component';
import { CustomerdashboardComponent } from './customerdashboard/customerdashboard.component';
import { SignupComponent } from './signup/signup.component';
import { AddmedicineComponent } from './addmedicine/addmedicine.component';
import { ViewmedicineComponent } from './viewmedicine/viewmedicine.component';
import { UpdatemedicineComponent } from './updatemedicine/updatemedicine.component';
import { Addtocart } from './addtocart';
import { AddToCartComponent } from './addtocart/addtocart.component';
import { ViewcartComponent } from './viewcart/viewcart.component';
import { OrderformComponent } from './orderform/orderform.component';
import { PaymentComponent } from './payment/payment.component';
import { ViewordersComponent } from './vieworders/vieworders.component';



const routes: Routes = [
  {path:"", component:LoginComponent},
  {path:"SignUp",component:SignupComponent},
  {path:"adminhome",component:AdmindashboardComponent,children:[
    {path:"addMedicine",component:AddmedicineComponent},
    {path:"updateMedicine",component:UpdatemedicineComponent},
    {path:"vieworders",component:ViewordersComponent}


    
  ]},
  {path:"customerhome",component:CustomerdashboardComponent,children:[
    {path:"viewMedicine",component:ViewmedicineComponent},
    
    
    
    
    
  ]},
  
  {path:"viewcart",component:ViewcartComponent},
  {path:"thankyou", component:OrderformComponent},
  {path:"login",component:LoginComponent},
  {path:"order-form", component:OrderformComponent},
  {path:"payment", component:PaymentComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
