import { Component, OnInit, Inject } from "@angular/core";
import { MatDialogRef, MAT_DIALOG_DATA } from "@angular/material";
import { DatosService } from "../_services/datosMaestros.service";
import { CampaignResponse } from "../_interfaces/campaign.interface";
import { CampaignService } from "../_services/campaign.service"
import { Datos } from "../_interfaces/datosMaestros.interface";
import { DatoEditado } from "../_dto/datoEditado.dto";

@Component({
    selector: 'app-dialog-editar-dato',
    templateUrl: './dialog-editar-dato.component.html',
    styleUrls: ['./dialog-editar-dato.component.css']
  })
  export class DialogEditarDatoComponent implements OnInit {
    dato: Datos;
    tipo: string;
    campaigns: CampaignResponse[];
    campanya: number;
    idDatoMaestro:number = this.data.idDato;
  
    constructor(private datosService: DatosService, public dialogRef: MatDialogRef<DialogEditarDatoComponent>,
      @Inject(MAT_DIALOG_DATA) public data: any) { }
  
    ngOnInit() {

    }
    
    editDato() {
      const datoCreate = new DatoEditado(this.idDatoMaestro ,this.tipo);
      this.datosService.editarDato(datoCreate).subscribe(dato => {
        this.dialogRef.close();
    });
    }

    validarCampoVacio(){

      if (this.tipo!='') {
        this.editDato();
      }else{
        console.log('Hay algún campo vacío.');
      }  
    }
  }