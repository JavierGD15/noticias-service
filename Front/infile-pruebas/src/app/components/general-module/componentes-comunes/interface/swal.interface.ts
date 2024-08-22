import Swal, { SweetAlertIcon } from 'sweetalert2';

export interface AlertParams {
    titulo?: string;
    mensaje?: string;
    icono: SweetAlertIcon;
    confirmButtonText?: string;
    cancelButtonText?: string;
    showCancelButton?: boolean;
    allowOutsideClick?: boolean,
  }
