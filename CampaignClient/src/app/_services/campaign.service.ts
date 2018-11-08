import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

const campaignUrl = `http://localhost:9000`;

@Injectable({
  providedIn: 'root'
})

export class CampaignService {
  token = localStorage.getItem('token');

  constructor(private http: HttpClient) { }

  getCampaigns() {
    const requestOptions = {
      headers: new HttpHeaders({
        'Authorization': `Bearer: ${this.token}`,
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*'
      })
    };

    return this.http.get(`${campaignUrl}/listarCampanyas`, requestOptions);
  }

}
