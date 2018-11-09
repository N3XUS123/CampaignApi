import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { RegistroCampanyaDto } from '../_dto/registroCampanya.dto';
import { RegistroCampanyaResponse } from '../_interfaces/registroCampanya-response.interface';

const registroCampanyaUrl = `http://localhost:9000`;

const token = localStorage.getItem('token');
const requestOptions = {
  headers: new HttpHeaders({
    'Authorization': `Bearer ${token}`,
    'Content-Type': 'application/json',
    'Access-Control-Allow-Origin': '*'
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
    localStorage.setItem('token', registroCampanyaResponse.token);
    localStorage.setItem('email', registroCampanyaResponse.email);
  }

}