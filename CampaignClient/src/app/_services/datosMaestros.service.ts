import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment.prod';
import { AuthService } from './auth.service';
import { Datos } from '../_interfaces/datosMaestros.interface';
import { DatoCreateDto } from '../_dto/datosMaestros.dto';
import { DatoCreateResponse } from '../_interfaces/datosMaestros-response.interface';
import { DatoEditado } from '../_dto/datoEditado.dto';
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

editarDato(datoEditadoDto: DatoEditado): Observable<Datos> {
    const requestOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${this.authService.getToken()}`,
        'Access-Control-Allow-Origin': '*'
      })
    };

    return this.http.put<Datos>(`${datosUrl}/edit/${datoEditadoDto.id}`, datoEditadoDto, requestOptions);
}

deleteDato(element: Datos): Observable<Datos[]>{
  console.log(element);
  const requestOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${this.authService.getToken()}`,
      'Access-Control-Allow-Origin': '*'
    })
  };

  return this.http.delete<Datos[]>(`${datosUrl}/remove/${element.id}`, requestOptions);
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

   getDatosCampanya(): Observable<Datos[]> {
    const requestOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${this.authService.getToken()}`,
        'Access-Control-Allow-Origin': '*'
      })
    };

    return this.http.get<Datos[]>(`${datosUrl}/listarDatosCampanya`, requestOptions);
   }
}