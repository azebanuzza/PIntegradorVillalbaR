import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HSkills } from 'src/app/model/hskills';
import { HskillsService } from 'src/app/service/hskills.service';

@Component({
  selector: 'app-new-hskills',
  templateUrl: './new-hskills.component.html',
  styleUrls: ['./new-hskills.component.css'],
})
export class NewHSkillsComponent implements OnInit {
  hsskills: HSkills = new HSkills('', '', '', '');
  namehs: string = '';
  percentage: string = '';
  icon: string = '';
  color: string = '';

  constructor(private sHSkills: HskillsService, private router: Router) {}

  ngOnInit(): void {}

  onCreate(): void {
    const hskills = new HSkills(
      this.namehs,
      this.percentage,
      this.icon,
      this.color
    );
    this.sHSkills.save(hskills).subscribe(
      (data) => {
        alert('Hard skill añadida');
        this.router.navigate(['']);
      },
      (err) => {
        alert('Error al añadir hard skill.');
        this.router.navigate(['']);
      }
    );
  }
}
