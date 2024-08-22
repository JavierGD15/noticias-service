import { Clasificacion } from "./clasificaciones.interface";


export interface Noticia {
  id_noticias: number;
  titulo: string;
  clasificacion: Clasificacion;
  descripcion: string;
  fecha_creacion: string;
  texto: string;
  enlace_photo: string;
}