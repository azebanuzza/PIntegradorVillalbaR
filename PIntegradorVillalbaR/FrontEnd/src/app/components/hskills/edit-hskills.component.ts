import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HskillsService } from 'src/app/service/hskills.service';
import { HSkills } from 'src/app/model/hskills';

@Component({
  selector: 'app-edit-hskills',
  templateUrl: './edit-hskills.component.html',
  styleUrls: ['./edit-hskills.component.css'],
})
export class EditHskillsComponent implements OnInit {
  hskill: HSkills = null;

  constructor(
    private sHSkills: HskillsService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    const id = this.activatedRoute.snapshot.params['id'];
    this.sHSkills.detail(id).subscribe(
      (data) => {
        this.hskill = data;
      },
      (err) => {
        alert('Error al modificar "Hard skills".');
        this.router.navigate(['']);
      }
    );
  }

  onUpdate(): void {
    //Esto busca el id del método que debe editar
    const id = this.activatedRoute.snapshot.params['id'];
    this.sHSkills.update(id, this.hskill).subscribe(
      (data) => {
        this.router.navigate(['']);
      },
      (err) => {
        alert('Error al modificar "Hard skill".');
        this.router.navigate(['']);
      }
    );
  }
}
