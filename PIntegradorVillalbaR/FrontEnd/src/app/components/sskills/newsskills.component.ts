import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SskillsService } from 'src/app/service/sskills.service';
import { SSkills } from 'src/app/model/sskills';

@Component({
  selector: 'app-newsskills',
  templateUrl: './newsskills.component.html',
  styleUrls: ['./newsskills.component.css'],
})
export class NewsskillsComponent implements OnInit {
  ssskills: SSkills = new SSkills('', '', '', '');
  namess: string = '';
  percentage: string = '';
  icon: string = '';
  color: string = '';

  constructor(private sSSkills: SskillsService, private router: Router) {}

  ngOnInit(): void {}

  onCreate(): void {
    const sskills = new SSkills(
      this.namess,
      this.percentage,
      this.icon,
      this.color
    );
    this.sSSkills.save(sskills).subscribe(
      (data) => {
        alert('Soft skill añadida');
        this.router.navigate(['']);
      },
      (err) => {
        alert('Error al añadir soft skill.');
        this.router.navigate(['']);
      }
    );
  }
}
