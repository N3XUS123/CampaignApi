import { Component, OnInit } from "@angular/core";
import { MatDialogRef } from "@angular/material";
import { DatosService } from "../_services/datosMaestros.service";
import { DatoMaestro } from "../_models/datoMaestro";
import { CampaignResponse } from "../_interfaces/campaign.interface";

@Component({
    selector: 'app-dialog-nuevo-dato',
    templateUrl: './dialog-nuevo-dato.component.html',
    styleUrls: ['./dialog-nuevo-dato.component.css']
  })
  export class DialogNuevoDatoComponent implements OnInit {
    tipo: string;
    campaigns: CampaignResponse[];
  
    constructor(private datosService: DatosService,
      public dialogRef: MatDialogRef<DialogNuevoDatoComponent>) { }
  
    ngOnInit() {
    }
  
    addDato() {
      const datoCreate = new DatoMaestro(this.tipo, this.campanya);
      this.datosService.createDato(datoCreate).subscribe(
        dato => {
          this.dialogRef.close(dato);
        }
      );
    }
  
  }