import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { HttpParams, HttpClient } from '@angular/common/http';
import { Noticia } from '../interface/noticias.interface';

@Injectable({
  providedIn: 'root'
})
export class noticiasService {

  constructor(
    private http: HttpClient
  ) { }



  private baseURL = environment.API_CARGA;


 

  getNoticias(): Observable<Noticia[]> {
    return this.http.get<Noticia[]>(`${this.baseURL}/noticias`);
  }
}
