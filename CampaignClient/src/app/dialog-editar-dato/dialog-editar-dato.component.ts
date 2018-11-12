import { Component, OnInit, Inject } from "@angular/core";
import { MatDialogRef, MAT_DIALOG_DATA } from "@angular/material";
import { DatosService } from "../_services/datosMaestros.service";
import { CampaignResponse } from "../_interfaces/campaign.interface";
import { CampaignService } from "../_services/campaign.service"
import { DatoEditado } from "../_dto/datoEditado.dto";

@Component({
    selector: 'app-dialog-editar-dato',
    templateUrl: './dialog-editar-dato.component.html',
    styleUrls: ['./dialog-editar-dato.component.css']
  })
  export class DialogEditarDatoComponent implements OnInit {
    tipo: string;
    campaigns: CampaignResponse[];
    campanya: number;
    idDatoMaestro: any;
  
    constructor(private datosService: DatosService, private campaignService: CampaignService,
      public dialogRef: MatDialogRef<DialogEditarDatoComponent>,
      @Inject(MAT_DIALOG_DATA) public data: any) { }
  
    ngOnInit() {
        this.idDatoMaestro = this.data.idDato;
        this.campaignService.getCampaigns().subscribe(campaignList => {
          this.campaigns = campaignList;
        }, error => {
          console.log('Error. No recibe datos.');
        });

    }
  /*
    editDato() {   
      const datoEdit = new DatoEditado(this.idDatoMaestro, this.tipo);
      this.datosService.createDato(datoEdit).subscribe(
       dato => {
         this.dialogRef.close(dato);
      }
     );
    }
  */
  }