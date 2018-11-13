import { Component, OnInit } from '@angular/core';
import { RegistroDto } from '../_dto/registro.dto';
import { RegistroService } from '../_services/registro.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']
})
export class RegistroComponent implements OnInit {

  nombreUsuario: string;
  email: string;
  contrasenya: string;
  grupo: string;
  contrasenyaRepetida: string;

  constructor(private registroService: RegistroService, private router: Router) { }

  ngOnInit() {
  }

  doRegistro() {
    if (this.validarPassRepetida()) {
      const registroDto = new RegistroDto(this.nombreUsuario, this.email, this.contrasenya, this.grupo);
    this.registroService.registro(registroDto).subscribe(registroResp => {
      this.registroService.setRegistroData(registroResp);
      this.router.navigate(['/main']);

    }, error => {
      console.log('Error en petición de registro');
    }
    );
    }
    
}

validarPassRepetida(){
  if (this.contrasenya===this.contrasenyaRepetida) {
    return true;
  }else{
    return false;
  }
}

validarCampoVacio(){
  
    let re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

    if (re.test(String(this.email).toLowerCase()) || this.contrasenya.length > 4 || this.nombreUsuario!='' || this.email!='' || this.contrasenya!='' || this.grupo!='') {
      this.doRegistro();
    }else{
      console.log('Hay algún campo vacío.');
    }  
}

}
