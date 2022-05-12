import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { CredentialsDto } from '../model/CredentialsDto';
import { Student } from '../model/Student';

@Injectable({
  providedIn: 'root'
})
export class TokenServiceService {

  urlBase:string = "http://localhost:8000/crud";
  token: string | undefined;
  user:string = "admin";
  pwd:string = "admin";
  
  constructor(private http:HttpClient) {

   }

  getToken(){
    let dto:CredentialsDto = new CredentialsDto();
    dto.pwd=this.pwd;
    dto.user=this.user;
    this.http.post<string>(this.urlBase+"/login",dto).subscribe(data=> this.token = data)
  }

  getStudentId(idAlumno:number){
    if(this.token == undefined){
      this.getToken
    }
    let heads: HttpHeaders = new HttpHeaders();
    heads.append("Authorization", "Bearer "+this.token);
    return this.http.get<Student>(this.urlBase+"/Alumno"+idAlumno,{headers: heads})
  }

  getStudents(){
    if(this.token == undefined){
      this.getToken
    }
    let heads: HttpHeaders = new HttpHeaders();
    heads.append("Authorization", "Bearer "+this.token);
    return this.http.get<Student[]>(this.urlBase+"/Alumnos",{headers: heads})
  }

}
