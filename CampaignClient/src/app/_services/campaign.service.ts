import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CampaignResponse } from '../_interfaces/campaign.interface';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.prod';
import { CampaignsDto } from '../_dto/campaigns.dto';

const campaignUrl = `${environment.apiUrl}/campanyas`;

@Injectable({
  providedIn: 'root'
})

export class CampaignService {

  token = localStorage.getItem('token');
  requestOptions = {
    headers: new HttpHeaders({
      'Authorization': `Bearer ${this.token}`,
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': '*'
    })
  };

  constructor(private http: HttpClient) { }

  getCampaigns(): Observable<CampaignResponse[]> {
    return this.http.get<CampaignResponse[]>(`${campaignUrl}/list`, this.requestOptions);
  }

  getJoinedCampaigns(): Observable<CampaignResponse[]> {
    return this.http.get<CampaignResponse[]>(`${campaignUrl}/list/mine`, this.requestOptions);
  }

  eliminarCampanya(id: number): Observable<CampaignResponse[]> {
    return this.http.delete<CampaignResponse[]>(`${campaignUrl}/remove/${id}`, this.requestOptions);
  }

  joinCampaign(code: String): Observable<CampaignResponse[]> {
    return this.http.post<CampaignResponse[]>(`${campaignUrl}/join`, code, this.requestOptions);
  }
}
