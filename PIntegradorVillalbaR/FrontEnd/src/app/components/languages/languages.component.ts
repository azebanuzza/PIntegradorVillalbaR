import { Token } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { Languages } from 'src/app/model/languages';
import { SlanguagesService } from 'src/app/service/slanguages.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-languages',
  templateUrl: './languages.component.html',
  styleUrls: ['./languages.component.css'],
})
export class LanguagesComponent implements OnInit {
  lang: Languages[] = [];

  constructor(
    private sLanguages: SlanguagesService,
    private tokenService: TokenService
  ) {}

  isLogged = false;

  ngOnInit(): void {
    this.cargarLanguages();
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }

  cargarLanguages(): void {
    this.sLanguages.lista().subscribe((data) => {
      this.lang = data;
    });
  }

  delete(id?: number) {
    if (id != undefined) {
      this.sLanguages.delete(id).subscribe(
        (data) => {
          this.cargarLanguages();
        },
        (err) => {
          alert('No se pudo eliminar el lenguaje.');
        }
      );
    }
  }
}
