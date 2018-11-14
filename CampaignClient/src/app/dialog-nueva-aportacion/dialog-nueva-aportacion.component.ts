import { Component, OnInit, Inject } from "@angular/core";
import { AportacionService } from "../_services/aportacion.service";
import { MatDialogRef, MAT_DIALOG_DATA } from "@angular/material";
import { AportacionCreateDto } from "../_dto/aportacion-create.dto";
import { Aportacion } from "../_models/aportacion";
import { Datos } from "../_interfaces/datosMaestros.interface";
import { DatosService } from "../_services/datosMaestros.service";

@Component({
  selector: 'app-dialog-nueva-aportacion',
  templateUrl: './dialog-nueva-aportacion.component.html',
  styleUrls: ['./dialog-nueva-aportacion.component.css']
})
export class DialogNuevaAportacionComponent implements OnInit {
  dato: string;
  cantidad: number;
  idCampanya: number;
  idDatosMaestros: number;
  datosMaestros: Datos[];

  constructor(private aportacionService: AportacionService, private datosMaestrosService: DatosService,
    public dialogRef: MatDialogRef<DialogNuevaAportacionComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any) { }

  ngOnInit() {
    this.idCampanya = this.data.idCamp;
    this.datosMaestrosService.getAllDatos().subscribe(datosList => {
      this.datosMaestros = datosList;
    }, error => {
      console.log('Error. No recibe datos.');
    });
  }

  saveAportacion() {
    const aportacionCreate = new AportacionCreateDto(this.dato, this.cantidad, this.idCampanya, this.idDatosMaestros);
    this.aportacionService.createAportacion(aportacionCreate).subscribe(
     aportacion => {
       this.dialogRef.close(aportacion);
    }
   );
  }

}