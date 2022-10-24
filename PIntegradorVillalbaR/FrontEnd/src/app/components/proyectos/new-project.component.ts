import { Component, OnInit } from '@angular/core';
import { Project } from 'src/app/model/project';
import { Router } from '@angular/router';
import { SProjectService } from 'src/app/service/sproject.service';

@Component({
  selector: 'app-new-project',
  templateUrl: './new-project.component.html',
  styleUrls: ['./new-project.component.css'],
})
export class NewProjectComponent implements OnInit {
  project: Project = new Project('', '', '', '', '', '');
  proName: string = '';
  proDescription: string = '';
  proImg: string = '';
  opUrl: string = '';
  altImg: string = '';
  repository: string = '';

  constructor(private router: Router, private sProject: SProjectService) {}

  ngOnInit(): void {}

  onCreate(): void {
    const project = new Project(
      this.proName,
      this.proDescription,
      this.proImg,
      this.opUrl,
      this.altImg,
      this.repository
    );
    this.sProject.save(project).subscribe(
      (data) => {
        alert('Proyecto añadido');
        this.router.navigate(['']);
      },
      (err) => {
        alert('Error al añadir proyecto');
        this.router.navigate(['']);
      }
    );
  }
}
