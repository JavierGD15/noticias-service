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

  getNoticia(id: string): Observable<Noticia> {
    return this.http.get<Noticia>(`${this.baseURL}/noticias/${id}`);
  }

  

  getRelacionadas(nombreClasificacion: string): Observable<Noticia[]> {
    // Hacemos la solicitud GET sin token
    return this.http.get<Noticia[]>(`${this.baseURL}/noticias/clasificacion`, { 
      params: { nombreClasificacion: nombreClasificacion }
    });
  }
}
