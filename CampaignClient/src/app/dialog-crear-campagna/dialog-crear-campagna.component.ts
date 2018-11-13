import { Component, OnInit } from '@angular/core';
import { RegistroCampanyaService } from '../_services/registroCampanya.service';
import { RegistroCampanyaDto } from '../_dto/registroCampanya.dto';
import { MatDialogRef } from '@angular/material';

@Component({
  selector: 'app-dialog-crear-campagna.',
  templateUrl: './dialog-crear-campagna.component.html',
  styleUrls: ['./dialog-crear-campagna.component.css']
})
export class DialogRegistroCampanyaComponent implements OnInit {

  nombreCampanya: string;
  codigo: string;

  constructor(private registroCampanyaService: RegistroCampanyaService,  public dialogRef: MatDialogRef<DialogRegistroCampanyaComponent>) { }

  ngOnInit() {
  }

addCampanya() {
    const registroCampanyaDto = new RegistroCampanyaDto(this.nombreCampanya, this.codigo);
    this.registroCampanyaService.createCampanya(registroCampanyaDto).subscribe(registroCampanyaResp => {
      this.dialogRef.close(registroCampanyaResp);
  });

  if (this.nombreCampanya!='' || this.codigo!='') {
    this.addCampanya();
  }else{
    console.log('Hay algún campo vacío.');
  }  
}
}