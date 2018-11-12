import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { MaterialModule } from './material.module';
import { LoginComponent } from './login/login.component';
import { FormsModule } from '@angular/forms';
import { RegistroComponent } from './registro/registro.component';
import { AppRoutingModule } from './app-routing.module'; 
import { RouterModule } from '@angular/router';
import { DatosMaestrosComponent } from './DatosMaestros/datosMaestros.component';
import { RegistroCampanyaComponent } from './registroCampanya/registroCampanya.component';
import { MainComponent } from './main/main.component';
import { FlexLayoutModule } from '@angular/flex-layout';
import { MatTableModule } from '@angular/material/table';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatChipsModule } from '@angular/material/chips';
import { MatDialogModule, MAT_DIALOG_DEFAULT_OPTIONS } from '@angular/material/dialog';
import { DialogNuevoDatoComponent } from './dialog-nuevo-dato/dialog-nuevo-dato.component';
import { AuthService } from './_services/auth.service';
import { DatosService } from './_services/datosMaestros.service';
import { DialogNuevaAportacionComponent } from './dialog-nueva-aportacion/dialog-nueva-aportacion.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistroComponent,
    DatosMaestrosComponent,
    RegistroCampanyaComponent,
    MainComponent,
    DialogNuevoDatoComponent,
    DialogNuevaAportacionComponent 
  ],
  entryComponents: [
    DialogNuevoDatoComponent,
    DialogNuevaAportacionComponent
],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MaterialModule,
    FormsModule,
    RouterModule,
    AppRoutingModule,
    FlexLayoutModule,
    MatTableModule,
    MatSnackBarModule,
    MatChipsModule,
    MatDialogModule,
  ],
  providers: [AuthService, DatosService,
    {provide: MAT_DIALOG_DEFAULT_OPTIONS, useValue: {hasBackdrop: true}}],
  bootstrap: [AppComponent]
})
export class AppModule { }
