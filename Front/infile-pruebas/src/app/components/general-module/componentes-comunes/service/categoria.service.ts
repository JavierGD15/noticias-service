import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { HttpParams, HttpClient } from '@angular/common/http';
import { Noticia } from '../interface/noticias.interface';
import { Clasificacion } from '../interface/clasificaciones.interface';

@Injectable({
  providedIn: 'root'
})
export class categoriaService {

  constructor(
    private http: HttpClient
  ) { }



  private baseURL = environment.API_CARGA;


 

  getCategorias(): Observable<Clasificacion[]> {
    return this.http.get<Clasificacion[]>(`${this.baseURL}/clasificaciones`);
  }
}
