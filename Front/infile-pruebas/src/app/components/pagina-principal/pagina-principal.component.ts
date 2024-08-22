import { Component, OnInit } from '@angular/core';
import { Clasificacion } from '../general-module/componentes-comunes/interface/clasificaciones.interface';
import { Noticia } from '../general-module/componentes-comunes/interface/noticias.interface';
import { noticiasService } from '../general-module/componentes-comunes/service/noticias.service';
import { categoriaService } from '../general-module/componentes-comunes/service/categoria.service';

@Component({
  selector: 'app-pagina-principal',
  templateUrl: './pagina-principal.component.html',
  styleUrls: ['./pagina-principal.component.scss']
})
export class PaginaPrincipalComponent implements OnInit {

  categorias: Clasificacion[] = [];
  noticias: Noticia[] = [];
  selectedCategoria: number = 0;
  filteredNoticias: Noticia[] = [];

  constructor(private dataService: noticiasService, private CategoriaService: categoriaService) { }

  ngOnInit(): void {
    this.CategoriaService.getCategorias().subscribe(data => {
      this.categorias = data;
    });

    this.dataService.getNoticias().subscribe(data => {
      this.noticias = data;
      this.filteredNoticias = this.noticias;
    });
  }

  filtrarNoticias(): void {
    if (this.selectedCategoria == 0) {
      this.filteredNoticias = this.noticias;
    } else {
      this.filteredNoticias = this.noticias.filter(noticia => noticia.clasificacion.id_clasificacion === this.selectedCategoria);
    }
  }

}
