import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Person } from './model/person';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PersonService {



  //private baseUrl = 'http://192.168.1.12:8081/scm/api';
  private baseUrl = 'http://localhost:8081/scm/api';

  constructor(private http: HttpClient) { }

  getPerson(id: number): Observable<Object> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  createPerson(person: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}` + `/person`, person);
  }

  updatePerson(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deletePerson(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}` + `/person` + `/${id}`, { responseType: 'text' });
  }

  getPersonList(): Observable<any> {
    return this.http.get(`${this.baseUrl}` + `/people`);
  }

  deleteAll(): Observable<any> {
    return this.http.delete(`${this.baseUrl}` + `/delete`, { responseType: 'text' });
  }

  getPersonByName(name: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/person/name/${name}`);
  }

}
