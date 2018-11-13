import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { RegistroCampanyaDto } from '../_dto/registroCampanya.dto';
import { RegistroCampanyaResponse } from '../_interfaces/registroCampanya-response.interface';
import { environment } from 'src/environments/environment.prod';
import { AuthService } from './auth.service';

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

  constructor(private http: HttpClient, private authService: AuthService) { }

  createCampanya(registroCampanyaDto: RegistroCampanyaDto): Observable<RegistroCampanyaResponse> {
    const requestOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${this.authService.getToken()}`,
        'Access-Control-Allow-Origin': '*'
      })
    };

    return this.http.post<RegistroCampanyaResponse>(`${registroCampanyaUrl}/add`, registroCampanyaDto, requestOptions);
}

  /*
  registroCampanya(registroCampanyaDto: RegistroCampanyaDto): Observable<RegistroCampanyaResponse> {
    return this.http.post<RegistroCampanyaResponse>(`${registroCampanyaUrl}/new`, registroCampanyaDto, requestOptions);
  }

  setRegistroCampanyaData(registroCampanyaResponse: RegistroCampanyaResponse) {
    localStorage.setItem('nombreCampanya', registroCampanyaResponse.nombreCampanya);
    localStorage.setItem('codigo', registroCampanyaResponse.codigo);
  }
*/
}