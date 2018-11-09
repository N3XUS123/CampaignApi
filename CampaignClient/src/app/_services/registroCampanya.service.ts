import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { RegistroCampanyaDto } from '../_dto/registroCampanya.dto';
import { RegistroCampanyaResponse } from '../_interfaces/registroCampanya-response.interface';

const registroCampanyaUrl = `http://localhost:9000`;
const token = localStorage.getItem('token');

const requestOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    'Access-Control-Allow-Origin': '*',
    'Authorization': `Bearer ${token}`

  })
};

@Injectable({
  providedIn: 'root'
})
export class RegistroCampanyaService {

  constructor(private http: HttpClient) { }

  registroCampanya(registroCampanyaDto: RegistroCampanyaDto): Observable<RegistroCampanyaResponse> {
    return this.http.post<RegistroCampanyaResponse>(`${registroCampanyaUrl}/registroCampanya`, registroCampanyaDto, requestOptions);
  }

  setRegistroCampanyaData(registroCampanyaResponse: RegistroCampanyaResponse) {
    localStorage.setItem('nombreCampanya', registroCampanyaResponse.nombreCampanya);
    localStorage.setItem('codigo', registroCampanyaResponse.codigo);
  }

}