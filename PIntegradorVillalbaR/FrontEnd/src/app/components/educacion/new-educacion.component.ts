import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Educacion } from 'src/app/model/educacion';
import { SEducacionService } from 'src/app/service/s-educacion.service';

@Component({
  selector: 'app-new-educacion',
  templateUrl: './new-educacion.component.html',
  styleUrls: ['./new-educacion.component.css'],
})
export class NewEducacionComponent implements OnInit {
  educacion: Educacion = new Educacion('', '', '', '', '');
  tituloEdu: string = '';
  descripcionEdu: string = '';
  fechaEdu: string = '';
  altImgEdu: string = '';
  imgEdu: string = '';

  constructor(private sEducacion: SEducacionService, private router: Router) {}

  ngOnInit(): void {}

  onCreate(): void {
    const educa = new Educacion(
      this.tituloEdu,
      this.descripcionEdu,
      this.fechaEdu,
      this.altImgEdu,
      this.imgEdu
    );
    this.sEducacion.save(educa).subscribe(
      (data) => {
        alert('Educación añadida.');
        this.router.navigate(['']);
      },
      (err) => {
        alert('Error al añadir educación.');
        this.router.navigate(['']);
      }
    );
  }
}
