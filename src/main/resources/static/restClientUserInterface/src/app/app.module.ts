import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {RouterModule,Routes} from '@angular/router';
import {HttpModule} from '@angular/http';
import {FormsModule} from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListuserComponent } from './components/listuser/listuser.component';
import { UserFormComponent } from './components/user-form/user-form.component';
import  {UserService} from './shared_service/user.service';
import { AuthGaurdService } from './shared_service/auth-gaurd.service';
import { from } from 'rxjs';
import { LoginComponent } from './components/login/login.component';
import { LogoutComponent } from './components/logout/logout.component';
import { HeaderComponent } from './components/header/header.component';


const appRoutes:Routes=[
  { path: '', component: ListuserComponent,canActivate:[AuthGaurdService] },
  //{path:'adminHome',component:ListuserComponent,canActivate:[AuthGaurdService]},
  {path:'op',component:UserFormComponent,canActivate:[AuthGaurdService]},
  {path:'login',component:LoginComponent},
  {path:'logout',component:LogoutComponent,canActivate:[AuthGaurdService]},
];
@NgModule({
  declarations: [
    AppComponent,
    ListuserComponent,
    UserFormComponent,
    LoginComponent,
    LogoutComponent,
    HeaderComponent
  ],
  imports: [
    FormsModule,
    BrowserModule,
    AppRoutingModule,
    HttpModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
