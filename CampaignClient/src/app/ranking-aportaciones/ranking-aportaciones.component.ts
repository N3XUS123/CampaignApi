import { Component, OnInit } from '@angular/core';
import { AportacionCreateResponse } from '../_interfaces/aportacion-create-response.interface';
import { AportacionService } from '../_services/aportacion.service';
import { MatSnackBar, MatDialog } from '@angular/material';
import { Campanya } from '../_models/campanya';
import { DialogNuevaAportacionComponent } from '../dialog-nueva-aportacion/dialog-nueva-aportacion.component';
import { Router } from '@angular/router';
import { Aportacion } from '../_models/aportacion';
import { CampaignService } from '../_services/campaign.service'

@Component({
  selector: 'app-ranking-aportaciones',
  templateUrl: './ranking-aportaciones.component.html',
  styleUrls: ['./ranking-aportaciones.component.css']
})
export class RankingAportacionesComponent implements OnInit {

  displayedColumns: string[] = ['dato', 'cantidad', 'fecha'];
  dataSource: AportacionCreateResponse[];
  campanyaId: number;

  constructor(private aportacionService: AportacionService,
    private campanyaService: CampaignService,
    public snackBar: MatSnackBar,
    public dialog: MatDialog) {}

  ngOnInit() {
    this.campanyaService.currentId.subscribe(message => (this.campanyaId = parseInt(message)));
    this.getAportaciones('Listado de datos cargado');
  }

  getAportaciones(mensaje: string) {
    this.aportacionService.getAllAportaciones(this.campanyaId).subscribe(listaAportaciones => {
      this.dataSource = listaAportaciones;

      this.snackBar.open(mensaje, 'Cerrar', {
        duration: 3000,
        verticalPosition: 'top'
      });
    }, error => {
      this.snackBar.open('Error al obtener datos', 'Cerrar', {
        duration: 3000,
      });
    });
  }

  openAportacionDialog(campanyaId) {
    const dialogAportacion = this.dialog.open(DialogNuevaAportacionComponent, {
      width: '250px',
      data: { idCamp: campanyaId}
    });

    dialogAportacion.afterClosed().subscribe(result => {
      this.getAportaciones('Aportación creada');
  });
}

  eliminarAportacion(aportacion: Aportacion) {
    this.aportacionService.deleteAportacion(aportacion).subscribe(listaAportaciones => {
      this.dataSource = listaAportaciones;
    })
    this.snackBar.open(`Eliminando ${aportacion.dato}`, 'Cerrar', {
      duration: 3000,
    });
  }
}
