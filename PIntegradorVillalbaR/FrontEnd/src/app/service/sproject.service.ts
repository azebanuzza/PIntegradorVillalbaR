import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Project } from '../model/project';

@Injectable({
  providedIn: 'root',
})
export class SProjectService {
  projURL = 'https://bewebportrv.herokuapp.com/project/';

  constructor(private httpClient: HttpClient) {}
  public lista(): Observable<Project[]> {
    return this.httpClient.get<Project[]>(this.projURL + 'lista');
  }

  public detail(id: number): Observable<Project> {
    return this.httpClient.get<Project>(this.projURL + `detail/${id}`);
  }

  public save(project: Project): Observable<any> {
    return this.httpClient.post<any>(this.projURL + `create`, project);
  }

  public update(id: number, project: Project): Observable<any> {
    return this.httpClient.put<any>(this.projURL + `update/${id}`, project);
  }

  public delete(id: number): Observable<any> {
    return this.httpClient.delete<any>(this.projURL + `delete/${id}`);
  }
}
