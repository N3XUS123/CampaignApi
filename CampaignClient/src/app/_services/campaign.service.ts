import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CampaignResponse } from '../_interfaces/campaign.interface';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.prod';

const campaignUrl = `${environment.apiUrl}/campanyas`;

@Injectable({
  providedIn: 'root'
})

export class CampaignService {
  token = localStorage.getItem('token');

  constructor(private http: HttpClient) { }

  getCampaigns(): Observable<CampaignResponse[]> {
    const requestOptions = {
      headers: new HttpHeaders({
        'Authorization': `Bearer ${this.token}`,
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*'
      })
    };

    return this.http.get<CampaignResponse[]>(`${campaignUrl}/list`, requestOptions);
  }

}
