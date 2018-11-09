import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment.prod';
import { AuthService } from './auth.service';
import { Datos } from '../_interfaces/datosMaestros.interface';
import { DatoCreateDto } from '../_dto/datosMaestros.dto';
import { DatoCreateResponse } from '../_interfaces/datosMaestros-response.interface';
const datosUrl = `${environment.apiUrl}/datosMaestros`;


@Injectable({
    providedIn: 'root'
  })
  export class DatosService {
    constructor(private http: HttpClient, private authService: AuthService) { }

createDato(datoCreateDto: DatoCreateDto): Observable<DatoCreateResponse> {
      const requestOptions = {
        headers: new HttpHeaders({
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${this.authService.getToken()}`,
          'Access-Control-Allow-Origin': '*'
        })
      };
  
      return this.http.post<DatoCreateResponse>(`${datosUrl}/add`, datoCreateDto, requestOptions);
  }

getAllDatos(): Observable<Datos[]> {
    const requestOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${this.authService.getToken()}`,
        'Access-Control-Allow-Origin': '*'
      })
    };

    return this.http.get<Datos[]>(`${datosUrl}/list`, requestOptions);
   }
}