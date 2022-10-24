import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { HSkills } from '../model/hskills';

@Injectable({
  providedIn: 'root',
})
export class HskillsService {
  hskillsURL = 'http://localhost:8080/hskills/';

  constructor(private httpClient: HttpClient) {}

  public lista(): Observable<HSkills[]> {
    return this.httpClient.get<HSkills[]>(this.hskillsURL + 'lista');
  }

  public detail(id: number): Observable<HSkills> {
    return this.httpClient.get<HSkills>(this.hskillsURL + `detail/${id}`);
  }

  public save(hskills: HSkills): Observable<any> {
    return this.httpClient.post<any>(this.hskillsURL + `create`, hskills);
  }

  public update(id: number, hskills: HSkills): Observable<any> {
    return this.httpClient.put<any>(this.hskillsURL + `update/${id}`, hskills);
  }

  public delete(id: number): Observable<any> {
    return this.httpClient.delete<any>(this.hskillsURL + `delete/${id}`);
  }
}
