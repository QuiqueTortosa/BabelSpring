import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Alumno } from '../model/Alumno';

@Injectable({
  providedIn: 'root'
})
export class AlumnoService {

  url:string="http://localhost:4000/06_GestionAlumnos/Buscador"
  url2:string="http://localhost:4000/06_GestionAlumnos/Cursos"

 // url:string="Buscador"
 // url2:string="Cursos"
  constructor(private http:HttpClient) { }

  buscar(curso:string) {
    return this.http.get<Alumno[]>(this.url, {params: {curso: curso}})
  }

  getCursos(){
    return this.http.get<string[]>(this.url2)
  }



}
