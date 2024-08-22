import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { PaginaPrincipalComponent } from './components/pagina-principal/pagina-principal.component';
import { DetalleNoticiasComponent } from './components/detalle-noticias/detalle-noticias.component';
import { GenerarUsuarioComponent } from './components/generar-usuario/generar-usuario.component';

const routes: Routes = [
  {
    path: 'inicio',
    component: LoginComponent,
  },
  {
    path: 'noticias',
    component: PaginaPrincipalComponent,
  },
  {
    path: 'detalle-noticias/:id',
    component: DetalleNoticiasComponent,
  },
  {
    path: 'registro',
    component: GenerarUsuarioComponent,
  },
  { path: '**', redirectTo: '/inicio' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
