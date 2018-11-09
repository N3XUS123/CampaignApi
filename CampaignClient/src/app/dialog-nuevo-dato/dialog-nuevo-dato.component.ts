import { Component, OnInit } from "@angular/core";
import { MatDialogRef } from "@angular/material";
import { DatosService } from "../_services/datosMaestros.service";
import { DatoMaestro } from "../_models/datoMaestro";

@Component({
    selector: 'app-dialog-nuevo-dato',
    templateUrl: './dialog-nuevo-dato.component.html',
    styleUrls: ['./dialog-nuevo-dato.component.css']
  })
  export class DialogNuevoDatoComponent implements OnInit {
    tipo: string;
    campanya: string;
  
    constructor(private datosService: DatosService,
      public dialogRef: MatDialogRef<DialogNuevoDatoComponent>) { }
  
    ngOnInit() {
    }
  
    addDato() {
      const datoCreate = new DatoMaestro(this.tipo, this.campanya);
      this.datosService.createDato(datoCreate).subscribe(
        note => {
          this.dialogRef.close();
        }
      );
    }
  
  }