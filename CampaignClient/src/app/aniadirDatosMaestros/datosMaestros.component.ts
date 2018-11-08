import { Component} from '@angular/core';

@Component({
  selector: 'app-listaDatos',
  templateUrl: './datosMaestros.component.html',
  styleUrls: ['./datosMaestros.component.css']
})
export class DatosMaestrosComponent{
    title = 'DatosMaestros';
    token = localStorage.getItem('token');
}