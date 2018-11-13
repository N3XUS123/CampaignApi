import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { RegistroCampanyaDto } from '../_dto/registroCampanya.dto';
import { RegistroCampanyaResponse } from '../_interfaces/registroCampanya-response.interface';
import { environment } from 'src/environments/environment.prod';

const registroCampanyaUrl = `${environment.apiUrl}/campanyas`;

const token = localStorage.getItem('token');
const requestOptions = {
  headers: new HttpHeaders({
    'Authorization': `Bearer ${token}`,
    'Content-Type': 'application/json',
    'Access-Control-Allow-Origin': '*',

  })
};

@Injectable({
  providedIn: 'root'
})
export class RegistroCampanyaService {

  constructor(private http: HttpClient) { }

  registroCampanya(registroCampanyaDto: RegistroCampanyaDto): Observable<RegistroCampanyaResponse> {
    return this.http.post<RegistroCampanyaResponse>(`${registroCampanyaUrl}/new`, registroCampanyaDto, requestOptions);
  }

}