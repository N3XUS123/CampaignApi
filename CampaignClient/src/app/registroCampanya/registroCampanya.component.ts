import { Component, OnInit } from '@angular/core';
import { RegistroCampanyaService } from '../_services/registroCampanya.service';
import { RegistroCampanyaDto } from '../_dto/registroCampanya.dto';

@Component({
  selector: 'app-registroCampanya',
  templateUrl: './registroCampanya.component.html',
  styleUrls: ['./registroCampanya.component.css']
})
export class RegistroCampanyaComponent implements OnInit {

  nombreCampanya: string;

  constructor(private registroCampanyaService: RegistroCampanyaService) { }

  ngOnInit() {
  }

  doRegistroCampanya() {
    const registroCampanyaDto = new RegistroCampanyaDto(this.nombreCampanya);
    this.registroCampanyaService.registroCampanya(registroCampanyaDto).subscribe(registroCampanyaResp => {
      console.log(registroCampanyaResp);
      this.registroCampanyaService.setRegistroCampanyaData(registroCampanyaResp);

    }, error => {
      console.log('Error en petición de registro');
    }
    );
}

}