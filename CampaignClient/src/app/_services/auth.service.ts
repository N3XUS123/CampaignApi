import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { LoginDto } from '../_dto/login.dto';
import { Observable } from 'rxjs';
import { LoginResponse } from '../_interfaces/login-response.interface';

const authUrl = `http://localhost:9000`;

const requestOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    'Access-Control-Allow-Origin': '*'
  })
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  // login(param1, param2): tipoQueDevuelveElMetodo
  login(loginDto: LoginDto): Observable<LoginResponse> {
    return this.http.post<LoginResponse>(`${authUrl}/auth`, loginDto, requestOptions);
  }

  setLoginData(loginResponse: LoginResponse) {
    localStorage.setItem('token', loginResponse.token);
    localStorage.setItem('email', loginResponse.email);
    localStorage.setItem('username', loginResponse.username);
    let admin = 'false';
    if (loginResponse.admin)
      admin = 'true';
    localStorage.setItem('admin', admin);
  }

  getToken(): String {
    return localStorage.getItem('token');
  }

  removeLoginData() {
    localStorage.removeItem('token');
    localStorage.removeItem('email');
    localStorage.removeItem('username');
    localStorage.removeItem('admin');
  }

  /*
  signup(email: string, password: string): string {
    return this.http.post(`${authUrl}/signup`, );
  }
  */
}