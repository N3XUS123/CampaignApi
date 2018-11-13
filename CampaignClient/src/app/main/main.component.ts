import { Component, OnInit, ViewChild, Input } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../_services/auth.service';
import { CampaignService } from '../_services/campaign.service';
import { CampaignResponse } from '../_interfaces/campaign.interface';
import { MatDialog } from '@angular/material';
import { DialogRegistroCampanyaComponent } from '../dialog-crear-campagna/dialog-crear-campagna.component';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {
  campaigns: CampaignResponse[];
  nombre = localStorage.getItem('username');

  id: Number;
  nombreCampanya: String;
  codigo: String;
  campaignInput: String;


  constructor(private authService: AuthService, private campaignService: CampaignService, private router: Router, public dialog: MatDialog) {}

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
    this.campaignService.getCampaigns().subscribe(campaignList => {
      this.campaigns = campaignList;
    }, error => {
      console.log('Error. No recibe datos.');
    });
  }

  openDialogNuevaCampagna() {
    const dialogoNuevaCampagna = this.dialog.open(DialogRegistroCampanyaComponent);

    dialogoNuevaCampagna.afterClosed().subscribe(result => {
      this.showData();
    });
  }

  isAdmin() {
    if (localStorage.getItem('admin') === 'true') {
      return true;
    }
  }

  DoEliminarCampanya(id) {
    this.campaignService.eliminarCampanya(id).subscribe(campaignList => {
      this.campaigns = campaignList;
    }, error => {
      console.log('Error.');
    });
  }

  joinCampaign() {
    this.campaignService.joinCampaign(this.campaignInput).subscribe(campaignList => {
      this.campaigns = campaignList;
    });
  }

  showMine() {
    this.campaignService.getJoinedCampaigns().subscribe(campaignList => {
      this.campaigns = campaignList;
    });
  }

  passIdCampanya(id:number) {
    this.campaignService.passidCampanya(id);
  }

}
