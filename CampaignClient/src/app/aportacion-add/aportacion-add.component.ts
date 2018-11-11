import { Component, OnInit } from "@angular/core";
import { AportacionService } from "../_services/aportacion.service";
import { AportacionCreateDto } from "../_dto/aportacion-create.dto";

@Component({
    selector: 'app-aportacion-add',
    templateUrl: './note-aportacion.component.html',
    styleUrls: ['./note-aportacion.component.css']
  })
  export class AportacionAddComponent implements OnInit {
    dato: string;
    cantidad: number;
  
    constructor(private aportacionService: AportacionService) { }
  
    ngOnInit() {
    }
  
    addAportacion() {
      const aportacionCreateDto = new AportacionCreateDto(this.dato, this.cantidad);
      this.aportacionService.createAportacion(aportacionCreateDto).subscribe(
        aportacion => {
          console.log(aportacion);
        }
      );
    }
  
  }