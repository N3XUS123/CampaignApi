import { Component, OnInit } from '@angular/core';
import { RegistroDto } from '../dto/registro.dto';
import { RegistroService } from '../services/registro.service';

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

  constructor(private registroService: RegistroService) { }

  ngOnInit() {
  }

  doRegistro() {
    const registroDto = new RegistroDto(this.nombreUsuario, this.email, this.contrasenya, this.grupo);
    this.registroService.registro(registroDto).subscribe(registroResp => {
      console.log(registroResp);
      this.registroService.setRegistroData(registroResp);

    }, error => {
      console.log('Error en petición de registro');
    }
    );
}

}
