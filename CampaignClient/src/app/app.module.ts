import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { MaterialModule } from './material.module';
import { LoginComponent } from './login/login.component';
import { FormsModule } from '@angular/forms';
import { RegistroComponent } from './registro/registro.component';

<<<<<<< HEAD
 import { AppRoutingModule } from './app-routing.module'; 
 import { RouterModule } from '@angular/router';
import { MainComponent } from './main/main.component';
=======
import { AppRoutingModule } from './app-routing.module'; 
import { RouterModule } from '@angular/router';
import { DatosMaestrosComponent } from './aniadirDatosMaestros/datosMaestros.component';
import { RegistroCampanyaComponent } from './registroCampanya/registroCampanya.component';
>>>>>>> 2e87914161671b11be9f02c739488b5b4a7db820

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistroComponent,
<<<<<<< HEAD
    MainComponent
=======
    DatosMaestrosComponent,
    RegistroCampanyaComponent
>>>>>>> 2e87914161671b11be9f02c739488b5b4a7db820
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MaterialModule,
    FormsModule,
    RouterModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
