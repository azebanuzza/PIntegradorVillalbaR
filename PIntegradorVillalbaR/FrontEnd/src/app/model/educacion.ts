export class Educacion {
  id?: number;
  tituloEdu?: string;
  descripcionEdu?: string;
  fechaEdu?: string;
  altImgEdu?: string;
  imgEdu?: string;

  constructor(
    tituloEdu: string,
    descripcionEdu: string,
    fechaEdu: string,
    altImgEdu: string,
    imgEdu: string
  ) {
    this.tituloEdu = tituloEdu;
    this.descripcionEdu = descripcionEdu;
    this.fechaEdu = fechaEdu;
    this.altImgEdu = altImgEdu;
    this.imgEdu = imgEdu;
  }
}
