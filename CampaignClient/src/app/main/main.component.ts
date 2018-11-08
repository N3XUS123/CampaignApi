import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../_services/auth.service';
import { CampaignService } from '../_services/campaign.service';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {
  nombreC: string;

  constructor(private authService: AuthService, private campaignService: CampaignService, private router: Router) {}

  ngOnInit() {
    if (this.authService.getToken() == null) {
      this.router.navigate(['/']);
    } else {
      this.showData();
    }
  }

  doLogout() {
    this.authService.removeLoginData();
    this.router.navigate(['/']);
  }

  showData() {
    this.campaignService.getCampaigns().subscribe(campaigns => {
      console.log('hola');
    }, error => {
      console.log('Error en petición de login');
    });
  }

}

