import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Languages } from 'src/app/model/languages';
import { SlanguagesService } from 'src/app/service/slanguages.service';

@Component({
  selector: 'app-newlang',
  templateUrl: './newlang.component.html',
  styleUrls: ['./newlang.component.css'],
})
export class NewlangComponent implements OnInit {
  languages: Languages = new Languages('', '', '', '', '');
  name: string = '';
  nivel: string = '';
  description: string = '';
  imgLang: string = '';
  altImg: string = '';

  constructor(private router: Router, private sLanguages: SlanguagesService) {}

  ngOnInit(): void {}

  onCreate(): void {
    const lang = new Languages(
      this.name,
      this.nivel,
      this.description,
      this.imgLang,
      this.altImg
    );
    this.sLanguages.save(lang).subscribe(
      (data) => {
        alert('Lenguaje añadido');
        this.router.navigate(['']);
      },
      (err) => {
        alert('Error al añadir lenguaje');
        this.router.navigate(['']);
      }
    );
  }
}
