import { Component, OnInit } from "@angular/core";
import { MatDialogRef } from "@angular/material";
import { DatosService } from "../_services/datosMaestros.service";
import { DatoMaestro } from "../_models/datoMaestro";
import { CampaignResponse } from "../_interfaces/campaign.interface";
import { CampaignsDto } from "../_dto/campaigns.dto"
import { CampaignService } from "../_services/campaign.service"

@Component({
    selector: 'app-dialog-nuevo-dato',
    templateUrl: './dialog-nuevo-dato.component.html',
    styleUrls: ['./dialog-nuevo-dato.component.css']
  })
  export class DialogNuevoDatoComponent implements OnInit {
    tipo: string;
    campaigns: CampaignResponse[];
    campanya: number;
  
    constructor(private datosService: DatosService, private campaignService: CampaignService,
      public dialogRef: MatDialogRef<DialogNuevoDatoComponent>) { }
  
    ngOnInit() {

        this.campaignService.getCampaigns().subscribe(campaignList => {
          this.campaigns = campaignList;
        }, error => {
          console.log('Error. No recibe datos.');
        });

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