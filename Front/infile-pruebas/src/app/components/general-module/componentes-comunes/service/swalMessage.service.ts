import { Injectable } from '@angular/core';
import Swal from 'sweetalert2';
import { AlertParams } from '../interface/swal.interface';


@Injectable({
    providedIn: 'root'
})
export class AlertService {

    constructor() { }

    mostrarAlerta(params: AlertParams) {
        return Swal.fire({
            title: params.titulo,
            text: params.mensaje,
            icon: params.icono,
            confirmButtonText: params.confirmButtonText || 'Aceptar',
            cancelButtonText: params.cancelButtonText || 'Cancelar',
            showCancelButton: params.showCancelButton || false,
            allowOutsideClick: params.allowOutsideClick || false,
            buttonsStyling: false,
            backdrop: true,
            customClass: {
                confirmButton: 'btn btn-confirm',
                cancelButton: 'btn btn-danger'
            }
        });
    }
}
