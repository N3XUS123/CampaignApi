import { Component, OnInit } from '@angular/core';
import { AuthService } from '../_services/auth.service';
import { LoginDto } from '../_dto/login.dto';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  email: '';
  password: '';

  constructor(private authService: AuthService, private router: Router) {}

  ngOnInit() {
    if (this.authService.getToken() != null) {
      window.location.replace('/main');
    }
  }

  doLogin() {
    const loginDto = new LoginDto(this.email, this.password);
    this.authService.login(loginDto).subscribe(loginResp => {
      this.authService.setLoginData(loginResp);
      window.location.replace('/main');
    }, error => {
      console.log('Error en petición de login');
    });
  }

  loginRegistro() {
    this.router.navigate(['registro.component']);
  }

}
