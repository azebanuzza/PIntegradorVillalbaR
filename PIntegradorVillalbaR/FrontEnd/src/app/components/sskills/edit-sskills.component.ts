import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { SskillsService } from 'src/app/service/sskills.service';
import { SSkills } from 'src/app/model/sskills';

@Component({
  selector: 'app-edit-sskills',
  templateUrl: './edit-sskills.component.html',
  styleUrls: ['./edit-sskills.component.css'],
})
export class EditSSkillsComponent implements OnInit {
  sskill: SSkills = null;

  constructor(
    private sSSkills: SskillsService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    const id = this.activatedRoute.snapshot.params['id'];
    this.sSSkills.detail(id).subscribe(
      (data) => {
        this.sskill = data;
      },
      (err) => {
        alert('Error al modificar "Soft skills".');
        this.router.navigate(['']);
      }
    );
  }

  onUpdate(): void {
    //Esto busca el id del método que debe editar
    const id = this.activatedRoute.snapshot.params['id'];
    this.sSSkills.update(id, this.sskill).subscribe(
      (data) => {
        this.router.navigate(['']);
      },
      (err) => {
        alert('Error al modificar "Soft skill".');
        this.router.navigate(['']);
      }
    );
  }
}
