import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  constructor(
    private http: HttpClient
  ) { }



  private baseURL = environment.API_CARGA;


 

  validarUsuario(correo: string, contra: string): Observable<string> {
    const body = { correo: correo, contra: contra };
    return this.http.post<string>(`${this.baseURL}/usuarios/login`, body);
  }
}
