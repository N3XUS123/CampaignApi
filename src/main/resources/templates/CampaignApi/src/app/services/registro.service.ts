import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment.prod';
import { Observable } from 'rxjs';
import { RegistroResponse } from '../interfaces/registro-response.interface';
import { RegistroDto } from '../dto/registro.dto';

const registroUrl = `${environment.apiUrl}/mynotesapi/auth`;

const requestOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class RegistroService {

  constructor(private http: HttpClient) { }

  registro(registroDto: RegistroDto): Observable<RegistroResponse> {
    return this.http.post<RegistroResponse>(`${registroUrl}/login`, RegistroDto, requestOptions);
  }

  setRegistroData(registroResponse: RegistroResponse) {
    localStorage.setItem('nombreUsuario', registroResponse.nombreUsuario);
    localStorage.setItem('email', registroResponse.email);
    localStorage.setItem('contrasenya', registroResponse.contrasenya);
    localStorage.setItem('grupo', registroResponse.grupo)
  }

}