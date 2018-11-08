
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegistroComponent } from './registro/registro.component';
<<<<<<< HEAD
import { MainComponent } from './main/main.component';

const routes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'registro', component: RegistroComponent },
  { path: 'login', component: LoginComponent },
  { path: 'main', component: MainComponent },
=======
import { DatosMaestrosComponent } from './aniadirDatosMaestros/datosMaestros.component';
import { RegistroCampanyaComponent } from './registroCampanya/registroCampanya.component';


const routes: Routes = [
  { path: 'datosMaestros', component: DatosMaestrosComponent },
  { path: 'registro', component: RegistroComponent },
  { path: 'login', component: LoginComponent },
  { path: '', component: LoginComponent },
  { path: 'registroCampanya', component: RegistroCampanyaComponent }
>>>>>>> 2e87914161671b11be9f02c739488b5b4a7db820
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  declarations: [],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }