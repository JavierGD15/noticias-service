import { Component, OnInit, ViewChild } from '@angular/core';
import { MatMenuTrigger } from '@angular/material/menu';

@Component({
  selector: 'app-navegacion',
  templateUrl: './navegacion.component.html',
  styleUrls: ['./navegacion.component.scss']
})
export class NavegacionComponent implements OnInit {
  activeTabIndex = -1; // Index por defecto para la pestaña
  @ViewChild('menuTrigger', { static: false }) menuTrigger!: MatMenuTrigger;
  constructor() { }

  ngOnInit(): void {
  }

  ocultarImagen() {
    console.log('ocultar imagen');
  }

}
