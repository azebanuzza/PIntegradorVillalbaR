import { Component, OnInit } from '@angular/core';
import { TokenService } from 'src/app/service/token.service';
import { SskillsService } from 'src/app/service/sskills.service';
import { SSkills } from 'src/app/model/sskills';

@Component({
  selector: 'app-sskills',
  templateUrl: './sskills.component.html',
  styleUrls: ['./sskills.component.css'],
})
export class SskillsComponent implements OnInit {
  sskills: SSkills[] = [];

  constructor(
    private sSSkills: SskillsService,
    private tokenService: TokenService
  ) {}

  isLogged = false;

  ngOnInit(): void {
    this.cargarSskills();
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }

  cargarSskills(): void {
    this.sSSkills.lista().subscribe((data) => {
      this.sskills = data;
    });
  }

  delete(id?: number) {
    if (id != undefined) {
      this.sSSkills.delete(id).subscribe(
        (data) => {
          this.cargarSskills();
        },
        (err) => {
          alert('No se pudo eliminar la hard skill.');
        }
      );
    }
  }
}
