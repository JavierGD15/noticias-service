import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { UsuarioInfo } from '../interface/usuario.interface';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  constructor(
    private http: HttpClient
  ) { }



  private baseURL = environment.API_CARGA;


 

  validarUsuario(correo: string, contra: string): Observable<any> {
    const body = { correo: correo, contra: contra };
    return this.http.post<any>(`${this.baseURL}/usuarios/login`, body);
  }

  crearUsuario(usuario: UsuarioInfo): Observable<any> {
    return this.http.post<any>(`${this.baseURL}/usuarios/register`, usuario);
  }

   // Método para almacenar el token en localStorage
   setToken(token: string): void {
    localStorage.setItem('jwtToken', token);
  }

  // Método para obtener el token almacenado
  getToken(): string | null {
    return localStorage.getItem('jwtToken');
  }

  // Método para eliminar el token de localStorage
  clearToken(): void {
    localStorage.removeItem('jwtToken');
  }
}
