import { Component, OnInit } from '@angular/core';
import { AportacionCreateResponse } from '../_interfaces/aportacion-create-response.interface';
import { AportacionService } from '../_services/aportacion.service';
import { MatSnackBar, MatDialog } from '@angular/material';
import { Campanya } from '../_models/campanya';
import { DialogNuevaAportacionComponent } from '../dialog-nueva-aportacion/dialog-nueva-aportacion.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-ranking-aportaciones',
  templateUrl: './ranking-aportaciones.component.html',
  styleUrls: ['./ranking-aportaciones.component.css']
})
export class RankingAportacionesComponent implements OnInit {

  displayedColumns: string[] = ['dato', 'cantidad', 'fecha'];
  dataSource: AportacionCreateResponse[];

  constructor(private aportacionService: AportacionService,
    public snackBar: MatSnackBar,
    public dialog: MatDialog,
    private router: Router) { }

  ngOnInit() {
    this.getAportaciones('Listado de datos cargado');
  }

  getAportaciones(mensaje: string) {
    this.aportacionService.getAllAportaciones().subscribe(listaAportaciones => {
      this.dataSource = listaAportaciones;

      this.snackBar.open(mensaje, 'Cerrar', {
        duration: 3000,
        verticalPosition: 'top'
      });
    },error =>  {
      this.snackBar.open('Error al obtener datos', 'Cerrar', {
        duration: 3000,
      });
    });
  }

  openAportacionDialog(campaign: Campanya) {
    const dialogRef = this.dialog.open(DialogNuevaAportacionComponent, {
      width: '250px',
      data: {idCamp: campaign.id}
    });
  }
}
