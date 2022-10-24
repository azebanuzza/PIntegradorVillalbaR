import { Component, OnInit } from '@angular/core';
import { Project } from 'src/app/model/project';
import { SProjectService } from 'src/app/service/sproject.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-proyectos',
  templateUrl: './proyectos.component.html',
  styleUrls: ['./proyectos.component.css'],
})
export class ProyectosComponent implements OnInit {
  project: Project[] = [];

  constructor(
    private sProject: SProjectService,
    private tokenService: TokenService
  ) {}

  isLogged = false;

  ngOnInit(): void {
    this.cargarProject();
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }

  cargarProject(): void {
    this.sProject.lista().subscribe((data) => {
      this.project = data;
    });
  }

  delete(id?: number) {
    if (id != undefined) {
      this.sProject.delete(id).subscribe(
        (data) => {
          this.cargarProject();
        },
        (err) => {
          alert('No se pudo eliminar el proyecto.');
        }
      );
    }
  }
}
