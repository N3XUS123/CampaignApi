
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegistroComponent } from './registro/registro.component';
import { DatosMaestrosComponent } from './DatosMaestros/datosMaestros.component';
import { RegistroCampanyaComponent } from './registroCampanya/registroCampanya.component';
import { MainComponent } from './main/main.component';


const routes: Routes = [
  { path: 'datosMaestros', component: DatosMaestrosComponent },
  { path: 'registro', component: RegistroComponent },
  { path: 'login', component: LoginComponent },
  { path: '', component: LoginComponent },
  { path: 'main', component: MainComponent },
  { path: 'registroCampanya', component: RegistroCampanyaComponent }
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