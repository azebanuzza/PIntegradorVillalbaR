import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Languages } from '../model/languages';

@Injectable({
  providedIn: 'root',
})
export class SlanguagesService {
  langURL = 'https://bewebportrv.herokuapp.com/lang/';

  constructor(private httpClient: HttpClient) {}
  public lista(): Observable<Languages[]> {
    return this.httpClient.get<Languages[]>(this.langURL + 'lista');
  }

  public detail(id: number): Observable<Languages> {
    return this.httpClient.get<Languages>(this.langURL + `detail/${id}`);
  }

  public save(educacion: Languages): Observable<any> {
    return this.httpClient.post<any>(this.langURL + `create`, educacion);
  }

  public update(id: number, educacion: Languages): Observable<any> {
    return this.httpClient.put<any>(this.langURL + `update/${id}`, educacion);
  }

  public delete(id: number): Observable<any> {
    return this.httpClient.delete<any>(this.langURL + `delete/${id}`);
  }
}
