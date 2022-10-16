import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Experiencia } from 'src/app/model/experiencia';
import { SExperienciaService } from 'src/app/service/s-experiencia.service';
import { ImageService } from 'src/app/service/image.service';

@Component({
  selector: 'app-new-experiencia',
  templateUrl: './new-experiencia.component.html',
  styleUrls: ['./new-experiencia.component.css'],
})
export class NewExperienciaComponent implements OnInit {
  experiencia: Experiencia = new Experiencia('', '', '', '', '');
  titulo: string = '';
  descripcion: string = '';
  fecha: string = '';
  alt: string = '';
  img: string = '';

  constructor(
    private sExperiencia: SExperienciaService,
    private router: Router,
    public imageService: ImageService
  ) {}

  ngOnInit(): void {}

  onCreate(): void {
    const expe = new Experiencia(
      this.titulo,
      this.descripcion,
      this.fecha,
      this.alt,
      this.img
    );
    this.sExperiencia.save(expe).subscribe(
      (data) => {
        alert('Experiencia añadida.');
        this.router.navigate(['']);
      },
      (err) => {
        alert('Error al añadir experiencia.');
        this.router.navigate(['']);
      }
    );
  }
}
