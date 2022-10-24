import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { SSkills } from '../model/sskills';

@Injectable({
  providedIn: 'root',
})
export class SskillsService {
  sskillsURL = 'http://localhost:8080/sskills/';

  constructor(private httpClient: HttpClient) {}

  public lista(): Observable<SSkills[]> {
    return this.httpClient.get<SSkills[]>(this.sskillsURL + 'lista');
  }

  public detail(id: number): Observable<SSkills> {
    return this.httpClient.get<SSkills>(this.sskillsURL + `detail/${id}`);
  }

  public save(sskills: SSkills): Observable<any> {
    return this.httpClient.post<any>(this.sskillsURL + `create`, sskills);
  }

  public update(id: number, sskills: SSkills): Observable<any> {
    return this.httpClient.put<any>(this.sskillsURL + `update/${id}`, sskills);
  }

  public delete(id: number): Observable<any> {
    return this.httpClient.delete<any>(this.sskillsURL + `delete/${id}`);
  }
}
