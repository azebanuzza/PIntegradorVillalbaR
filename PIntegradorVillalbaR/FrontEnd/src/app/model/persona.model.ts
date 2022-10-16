export class persona {
  id?: number; //El signo de interrogación marca que este dato no es necesario, así no tira error
  nombre: string;
  apellido: string;
  aboutme: string;
  img: string;

  constructor(nombre: string, apellido: string, aboutme: string, img: string) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.aboutme = aboutme;
    this.img = img;
  }
}

//Luego hay que crear un servicio que implemente este modelo.
