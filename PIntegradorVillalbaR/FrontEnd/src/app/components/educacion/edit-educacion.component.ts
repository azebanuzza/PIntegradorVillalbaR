import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { SEducacionService } from 'src/app/service/s-educacion.service';
import { Educacion } from 'src/app/model/educacion';

@Component({
  selector: 'app-edit-educacion',
  templateUrl: './edit-educacion.component.html',
  styleUrls: ['./edit-educacion.component.css'],
})
export class EditEducacionComponent implements OnInit {
  educa: Educacion = null;

  constructor(
    private sEducacion: SEducacionService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    const id = this.activatedRoute.snapshot.params['id'];
    this.sEducacion.detail(id).subscribe(
      (data) => {
        this.educa = data;
      },
      (err) => {
        alert('Error al modificar "Educación".');
        this.router.navigate(['']);
      }
    );
  }

  onUpdate(): void {
    //Esto busca el id del método que debe editar
    const id = this.activatedRoute.snapshot.params['id'];
    this.sEducacion.update(id, this.educa).subscribe(
      (data) => {
        this.router.navigate(['']);
      },
      (err) => {
        alert('Error al modificar "Educación".');
        this.router.navigate(['']);
      }
    );
  }
}
