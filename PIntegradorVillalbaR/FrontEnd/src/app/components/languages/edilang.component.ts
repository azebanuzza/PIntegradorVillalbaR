import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Languages } from 'src/app/model/languages';
import { SlanguagesService } from 'src/app/service/slanguages.service';

@Component({
  selector: 'app-edilang',
  templateUrl: './edilang.component.html',
  styleUrls: ['./edilang.component.css'],
})
export class EdilangComponent implements OnInit {
  lang: Languages = null;

  constructor(
    private sLanguages: SlanguagesService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    const id = this.activatedRoute.snapshot.params['id'];
    this.sLanguages.detail(id).subscribe(
      (data) => {
        this.lang = data;
      },
      (err) => {
        alert('Error al modificar "Lenguaje".');
        this.router.navigate(['']);
      }
    );
  }

  onUpdate(): void {
    //Esto busca el id del método que debe editar
    const id = this.activatedRoute.snapshot.params['id'];
    this.sLanguages.update(id, this.lang).subscribe(
      (data) => {
        this.router.navigate(['']);
      },
      (err) => {
        alert('Error al modificar "Lenguaje".');
        this.router.navigate(['']);
      }
    );
  }
}
