import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { UsuarioService } from '../general-module/componentes-comunes/service/usuario.service';
import { AlertService } from '../general-module/componentes-comunes/service/swalMessage.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {


  constructor(private formBuilder: FormBuilder, private tablaservice: UsuarioService,
    private alertService: AlertService, private router: Router
  ) { }

  ngOnInit(): void {
    this.tablaservice.clearToken();
  }

  loginForm = this.formBuilder.group({
    username: [''],
    password: ['']
  });


  onSubmit() {
    if (this.loginForm.valid) {
      const correo = this.loginForm.value.username
      const pass = this.loginForm.value.password

      this.tablaservice.validarUsuario(correo, pass).subscribe(
        (datas: any) => {
          const token = datas.token;
          this.tablaservice.setToken(token);
          this.alertService.mostrarAlerta({
            titulo: 'success',
            mensaje: "Inicio de sesión exitoso",
            icono: 'success'
          }).then(() => {
            this.router.navigate(['noticias']);
          });
          

        }, error => {
          this.alertService.mostrarAlerta({
            titulo: 'Información',
            mensaje: error.error,
            icono: 'info'
          }).then(() => {
            this.loginForm.reset();
          });
        }
      );
    }
  }



}
