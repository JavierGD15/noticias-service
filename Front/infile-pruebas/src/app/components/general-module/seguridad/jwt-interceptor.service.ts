import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Router } from '@angular/router';
import { UsuarioService } from '../componentes-comunes/service/usuario.service';

@Injectable()
export class JwtInterceptor implements HttpInterceptor {

    constructor(private authService: UsuarioService, private router: Router) { }

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        const token = this.authService.getToken();

        if (token) {
            request = request.clone({
                setHeaders: {
                    Authorization: `Bearer ${token}`
                }
            });
        }
        else {
            this.router.navigate(['/inicio']);
        }

        return next.handle(request).pipe(
            catchError((error: HttpErrorResponse) => {
                if (error.status === 401) {
                    // Redirigir al login si el token es inválido o ha expirado
                    this.authService.clearToken();
                    this.router.navigate(['/inicio']);
                }
                return throwError(error);
            })
        );
    }
}
