export class Languages {
  id?: number;
  name?: string;
  nivel?: string;
  description?: string;
  imgLang?: string;
  altImg?: string;

  constructor(
    name: string,
    nivel: string,
    description: string,
    imgLang: string,
    altImg: string
  ) {
    this.name = name;
    this.nivel = nivel;
    this.description = description;
    this.imgLang = imgLang;
    this.altImg = altImg;
  }
}
