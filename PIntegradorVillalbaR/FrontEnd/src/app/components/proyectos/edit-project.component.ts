import { Component, OnInit } from '@angular/core';
import { Project } from 'src/app/model/project';
import { SProjectService } from 'src/app/service/sproject.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-edit-project',
  templateUrl: './edit-project.component.html',
  styleUrls: ['./edit-project.component.css'],
})
export class EditProjectComponent implements OnInit {
  project: Project = null;

  constructor(
    private sProject: SProjectService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    const id = this.activatedRoute.snapshot.params['id'];
    this.sProject.detail(id).subscribe(
      (data) => {
        this.project = data;
      },
      (err) => {
        alert('Error al modificar "Proyecto".');
        this.router.navigate(['']);
      }
    );
  }

  onUpdate(): void {
    //Esto busca el id del método que debe editar
    const id = this.activatedRoute.snapshot.params['id'];
    this.sProject.update(id, this.project).subscribe(
      (data) => {
        this.router.navigate(['']);
      },
      (err) => {
        alert('Error al modificar "Proyecto".');
        this.router.navigate(['']);
      }
    );
  }
}
