import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CampaignResponse } from '../_interfaces/campaign.interface';
import { Observable, BehaviorSubject } from 'rxjs';
import { environment } from 'src/environments/environment.prod';
import { CampaignsDto } from '../_dto/campaigns.dto';
import { UsuarioLogueadoResponse } from '../_interfaces/usuarioLogeado.interface'

const campaignUrl = `${environment.apiUrl}/campanyas`;

@Injectable({
  providedIn: 'root'
})

export class CampaignService {
  private idSource = new BehaviorSubject('');
  currentId = this.idSource.asObservable();

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

  passidCampanya(id: number) {
    this.idSource.next(id.toString());
  }
  
  getUserData(): Observable<UsuarioLogueadoResponse> {
    return this.http.get<UsuarioLogueadoResponse>(`${environment.apiUrl}/usuario/getUserData`, this.requestOptions);
  }

}
