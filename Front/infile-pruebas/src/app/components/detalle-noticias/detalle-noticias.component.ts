import { Component, OnInit } from '@angular/core';
import { noticiasService } from '../general-module/componentes-comunes/service/noticias.service';
import { ActivatedRoute } from '@angular/router';
import { Noticia } from '../general-module/componentes-comunes/interface/noticias.interface';

@Component({
  selector: 'app-detalle-noticias',
  templateUrl: './detalle-noticias.component.html',
  styleUrls: ['./detalle-noticias.component.scss']
})
export class DetalleNoticiasComponent implements OnInit {
  noticia: Noticia | undefined;
  noticiasRelacionadas: Noticia[] = [];
  constructor(private dataService: noticiasService, private route: ActivatedRoute,) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      const receivedId = params.get('id');
      if (receivedId) {
        this.obtenerDatos(receivedId);
      }
    });
  }

  obtenerDatos(id: string): void {
    this.dataService.getNoticia(id).subscribe(data => {
      this.noticia = data;
      const nombreClasificacion = this.noticia.clasificacion.nombre;
      this.dataService.getRelacionadas(nombreClasificacion).subscribe(data => {
        console.log(data);
        this.noticiasRelacionadas = data;
      });
    });
  }


}
