import { Component, OnInit } from '@angular/core';
import { AportacionCreateResponse } from '../_interfaces/aportacion-create-response.interface';
import { AportacionService } from '../_services/aportacion.service';
import { MatSnackBar, MatDialog } from '@angular/material';
import { DialogNuevaAportacionComponent } from '../dialog-nueva-aportacion/dialog-nueva-aportacion.component';
import { Aportacion } from '../_models/aportacion';
import { CampaignService } from '../_services/campaign.service'
import { RankingResponse } from '../_interfaces/ranking-response.interface'

@Component({
  selector: 'app-ranking-aportaciones',
  templateUrl: './ranking-aportaciones.component.html',
  styleUrls: ['./ranking-aportaciones.component.css']
})
export class RankingAportacionesComponent implements OnInit {

  displayedColumns: string[] = ['datosMaestros', 'dato', 'cantidad', 'fecha', 'acciones'];
  rankingColumns: string[] = ['grupo', 'cantidad'];
  dataSource: AportacionCreateResponse[];
  ranking: RankingResponse[];
  campanyaId: number;

  constructor(private aportacionService: AportacionService,
    private campanyaService: CampaignService,
    public snackBar: MatSnackBar,
    public dialog: MatDialog) {}

  ngOnInit() {
    this.campanyaService.currentId.subscribe(message => (this.campanyaId = parseInt(message)));
    if(isNaN(this.campanyaId)){
      window.location.replace('/main');
    }
    this.getAportaciones('Listado de datos cargado');
    this.showRanking();

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
      data: { idCamp: campanyaId }
    });

    dialogAportacion.afterClosed().subscribe(result => {
      this.getAportaciones('Aportación creada');
  });
}

  eliminarAportacion(aportacion: Aportacion) {
    this.aportacionService.deleteAportacion(aportacion.id).subscribe(listaAportaciones => {
      this.dataSource = listaAportaciones;
    })
    this.snackBar.open(`Eliminando ${aportacion.dato}`, 'Cerrar', {
      duration: 3000,
    });
  }

  showRanking() {
    this.aportacionService.getRanking(this.campanyaId).subscribe(Ranking => {
      this.ranking = Ranking;
    })
  }
}
