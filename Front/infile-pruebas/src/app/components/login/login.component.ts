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
        (datas: string) => {

          this.router.navigate(['noticias']);

        }, error => {
          alert(error);
          this.alertService.mostrarAlerta({
            titulo: 'Información',
            mensaje: error.error.message,
            icono: 'info'
          }).then(() => {
            this.loginForm.reset();
          });
        }
      );
    }
  }



}
