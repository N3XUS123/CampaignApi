import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { RegistroResponse } from '../_interfaces/registro-response.interface';
import { RegistroDto } from '../_dto/registro.dto';
import { environment } from 'src/environments/environment.prod';

const registroUrl = `${environment.apiUrl}`;

const requestOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    'Access-Control-Allow-Origin': '*'
  })
};

@Injectable({
  providedIn: 'root'
})
export class RegistroService {

  constructor(private http: HttpClient) { }

  registro(registroDto: RegistroDto): Observable<RegistroResponse> {
    return this.http.post<RegistroResponse>(`${registroUrl}/registro`, registroDto, requestOptions);
  }

  setRegistroData(registroResponse: RegistroResponse) {
    localStorage.setItem('token', registroResponse.token);
  }

}