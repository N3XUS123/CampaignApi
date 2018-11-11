import { Component, OnInit } from "@angular/core";
import { AportacionService } from "../_services/aportacion.service";
import { MatDialogRef } from "@angular/material";
import { AportacionCreateDto } from "../_dto/aportacion-create.dto";

@Component({
    selector: 'app-dialog-nueva-aportacion',
    templateUrl: './dialog-nueva-aportacion.component.html',
    styleUrls: ['./dialog-nueva-aportacion.component.css']
  })
  export class DialogNuevaAportacionComponent implements OnInit {
    dato: string;
    cantidad: number;
  
    constructor(private aportacionService: AportacionService,
      public dialogRef: MatDialogRef<DialogNuevaAportacionComponent>) { }
  
    ngOnInit() {
    }
  
    addAportacion() {
      const aportacionCreateDto = new AportacionCreateDto(this.dato, this.cantidad);
      this.aportacionService.createAportacion(aportacionCreateDto).subscribe(
        aportacion => {
          this.dialogRef.close(aportacion);
        }
      );
    }
  
  }