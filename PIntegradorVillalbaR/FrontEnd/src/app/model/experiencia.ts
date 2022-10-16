export class Experiencia {
  id?: number;
  titulo?: string;
  descripcion?: string;
  fecha?: string;
  alt?: string;
  img?: string;

  constructor(
    titulo: string,
    descripcion: string,
    fecha: string,
    alt: string,
    img: string
  ) {
    this.titulo = titulo;
    this.descripcion = descripcion;
    this.fecha = fecha;
    this.alt = alt;
    this.img = img;
  }
}
