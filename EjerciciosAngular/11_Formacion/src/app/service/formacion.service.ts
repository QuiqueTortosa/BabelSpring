import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Curso } from '../model/Curso';
import { Alumno } from '../model/Alumno';

@Injectable({
  providedIn: 'root'
})
export class FormacionService {

  url:string="http://localhost:4000/11_proyecto_formacion/";

  constructor(private http:HttpClient) { }

  findCursos(){
    return this.http.get<Curso[]>("Cursos")
  }

  findAlumnos(){
    return this.http.get<Alumno[]>("Alumnos")
  }

  findCursosByAlumno(usuario:string) {
    return this.http.get<Curso[]>("findCursosByAlumnos", {params: {usuario: usuario}})
  }

  findAlumnosByCursos(nombre:string) {
    return this.http.get<Alumno[]>("findAlumnosByCurso", {params: {nombre: nombre}})
  }

}
