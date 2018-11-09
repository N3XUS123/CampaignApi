import { Component} from '@angular/core';
import { Datos } from '../_interfaces/datosMaestros.interface';
import { MatSnackBar, MatDialog } from '@angular/material';
import { DatosService } from '../_services/datosMaestros.service';
import { DialogNuevoDatoComponent } from '../dialog-nuevo-dato/dialog-nuevo-dato.component';

@Component({
  selector: 'app-listaDatos',
  templateUrl: './datosMaestros.component.html',
  styleUrls: ['./datosMaestros.component.css']
})
export class DatosMaestrosComponent{
  displayedColumns: string[] = ['numero', 'tipo', 'campanya', 'acciones'];
  dataSource: Datos[];

  constructor(private noteService: DatosService,
    public snackBar: MatSnackBar,
    public dialog: MatDialog) { }

  ngOnInit() {
    this.getListaDatos('Listado de datos cargado');
  }

  getListaDatos(mensaje: string) {
    this.noteService.getAllDatos().subscribe(listaDatos => {
      this.dataSource = listaDatos;

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

  openDialogNuevoDato() {
    const dialogoNuevoDato = this.dialog.open(DialogNuevoDatoComponent);

    dialogoNuevoDato.afterClosed().subscribe(result => {
      this.getListaDatos('Dato creado');
    });

  }

  eliminarDato(element: Datos) {
    this.snackBar.open(`Eliminando ${element.tipo}`, 'Cerrar', {
      duration: 3000,
    });
  }

}