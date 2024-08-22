import { Component, OnInit, ViewChild } from '@angular/core';
import { MatMenuTrigger } from '@angular/material/menu';
import { Clasificacion } from '../general-module/componentes-comunes/interface/clasificaciones.interface';
import { categoriaService } from '../general-module/componentes-comunes/service/categoria.service';

@Component({
  selector: 'app-navegacion',
  templateUrl: './navegacion.component.html',
  styleUrls: ['./navegacion.component.scss']
})
export class NavegacionComponent implements OnInit {
  activeTabIndex = -1; // Index por defecto para la pestaña
  @ViewChild('menuTrigger', { static: false }) menuTrigger!: MatMenuTrigger;
  constructor(private CategoriaService: categoriaService) { }
  categorias: Clasificacion[] = [];
  ngOnInit(): void {

    this.CategoriaService.getCategorias().subscribe(data => {
      this.categorias = data;
    });
  }

  ocultarImagen() {
    console.log('ocultar imagen');
  }



}
