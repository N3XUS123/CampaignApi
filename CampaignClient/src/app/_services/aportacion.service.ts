import { environment } from "src/environments/environment.prod";
import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthService } from "./auth.service";
import { AportacionCreateResponse } from "../_interfaces/aportacion-create-response.interface";
import { AportacionCreateDto } from "../_dto/aportacion-create.dto";
import { Observable } from "rxjs";
import { Aportacion } from "../_models/aportacion";
import { RankingResponse } from '../_interfaces/ranking-response.interface'

const aportacionUrl = `${environment.apiUrl}/aportaciones`;
const requestOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    'Authorization': `Bearer ${localStorage.getItem('token')}`,
    'Access-Control-Allow-Origin': '*'
  })
};

@Injectable({
  providedIn: 'root'
})
export class AportacionService {
  constructor(private http: HttpClient, private authService: AuthService) {}

  createAportacion(aportacionCreateDto: AportacionCreateDto): Observable < AportacionCreateResponse > {
    return this.http.post < AportacionCreateResponse > (`${aportacionUrl}/nuevaAportacion`, aportacionCreateDto, requestOptions);
  }

  getAllAportaciones(campanyaId: number): Observable < AportacionCreateResponse[] > {
    return this.http.get < AportacionCreateResponse[] > (`${aportacionUrl}/list/${campanyaId}`, requestOptions);
  }

  deleteAportacion(element:number): Observable < Aportacion[] > {
    return this.http.delete < Aportacion[] > (`${aportacionUrl}/remove/${element}`, requestOptions);
  }

  getRanking(campanyaId: number): Observable<RankingResponse[]> {
    return this.http.get<RankingResponse[]>(`${aportacionUrl}/rankingAportaciones/${campanyaId}`, requestOptions);
  }

}
