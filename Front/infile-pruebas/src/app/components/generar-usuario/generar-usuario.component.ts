import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { AlertService } from '../general-module/componentes-comunes/service/swalMessage.service';
import { Router } from '@angular/router';
import { UsuarioService } from '../general-module/componentes-comunes/service/usuario.service';
import { UsuarioInfo } from '../general-module/componentes-comunes/interface/usuario.interface';
@Component({
  selector: 'app-generar-usuario',
  templateUrl: './generar-usuario.component.html',
  styleUrls: ['./generar-usuario.component.scss']
})
export class GenerarUsuarioComponent implements OnInit {

  usuarioForm!: FormGroup;

  constructor(private fb: FormBuilder, private http: HttpClient, private alertService: AlertService, 
    private router: Router,private tablaservice: UsuarioService) { }

  ngOnInit(): void {
    this.usuarioForm = this.fb.group({
      nombre: ['', [Validators.required]],
      apellido: ['', [Validators.required]],
      edad: ['', [Validators.required, Validators.min(1)]],
      correo: ['', [Validators.required, Validators.email]],
      contra: ['', [Validators.required, Validators.minLength(6)]]
    });
  }

  onSubmit(): void {
    if (this.usuarioForm.valid) {
      const usuario: UsuarioInfo = {
        nombre: this.usuarioForm.value.nombre,
        apellido: this.usuarioForm.value.apellido,
        edad: this.usuarioForm.value.edad,
        correo: this.usuarioForm.value.correo,
        contra: this.usuarioForm.value.contra
      };
      this.tablaservice.crearUsuario(usuario).subscribe(
        (response: any) => {
          this.alertService.mostrarAlerta({
            titulo: 'success',
            mensaje: "Usuario creado exitosamente",
            icono: 'success'
          }).then(() => {
            this.router.navigate(['/inicio']);
          });
        },
        error => {
          console.log(error);
          this.alertService.mostrarAlerta({
            titulo: 'Información',
            mensaje: error,
            icono: 'info'
          });
        });
    }
  }
}