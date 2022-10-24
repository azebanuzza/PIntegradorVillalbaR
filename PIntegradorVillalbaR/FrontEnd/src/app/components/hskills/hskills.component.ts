import { Component, OnInit } from '@angular/core';
import { TokenService } from 'src/app/service/token.service';
import { HskillsService } from 'src/app/service/hskills.service';
import { HSkills } from 'src/app/model/hskills';

@Component({
  selector: 'app-hskills',
  templateUrl: './hskills.component.html',
  styleUrls: ['./hskills.component.css'],
})
export class HSkillsComponent implements OnInit {
  hskills: HSkills[] = [];

  constructor(
    private sHSkills: HskillsService,
    private tokenService: TokenService
  ) {}

  isLogged = false;

  ngOnInit(): void {
    this.cargarHskills();
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }

  cargarHskills(): void {
    this.sHSkills.lista().subscribe((data) => {
      this.hskills = data;
    });
  }

  delete(id?: number) {
    if (id != undefined) {
      this.sHSkills.delete(id).subscribe(
        (data) => {
          this.cargarHskills();
        },
        (err) => {
          alert('No se pudo eliminar la hard skill.');
        }
      );
    }
  }
}
