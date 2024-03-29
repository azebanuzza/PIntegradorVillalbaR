import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { persona } from '../model/persona.model';

@Injectable({
  providedIn: 'root',
})
export class PersonaService {
  URL = 'https://bewebportrv.herokuapp.com/personas';

  constructor(private httpClient: HttpClient) {}

  //Angular usa el Observable para hacer todas las comprobaciones asíncronas

  public lista(): Observable<persona[]> {
    return this.httpClient.get<persona[]>(this.URL + `/lista`);
  }

  public detail(id: number): Observable<persona> {
    return this.httpClient.get<persona>(this.URL + `/detail/${id}`);
  }

  public update(id: number, persona: persona): Observable<any> {
    return this.httpClient.put<any>(this.URL + `/update/${id}`, persona);
  }
}
