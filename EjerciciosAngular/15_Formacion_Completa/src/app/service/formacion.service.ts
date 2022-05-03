import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Curso } from '../model/Curso';
import { Alumno } from '../model/Alumno';
import { Matricula } from '../model/Matricula';

@Injectable({
  providedIn: 'root'
})
export class FormacionService {


  constructor(private http:HttpClient) { }

  findCursos(){
    return this.http.get<Curso[]>(`Cursos`)
  }

  findAlumnos(){
    return this.http.get<Alumno[]>(`Alumnos`)
  }

  consultaMatriculas(start: string, end: string){
    return this.http.get<Matricula[]>(`ConsultaMatriculas`, {params: {start: start, end: end}})
  }

  altaAlumno(usuario:string, password: string, nombre:string ,email:string, edad:Number){
    return this.http.post(`AltaAlumno?usuario=${usuario}&password=${password}&nombre=${nombre}&email=${email}&edad=${edad}`,null)
  }

  altaCurso(nombre:string, duracion: Number, precio:Number ,fechaInicio:string){
    return this.http.post(`AltaCurso?nombre=${nombre}&duracion=${duracion}&precio=${precio}&fechaInicio=${fechaInicio}`,null)
  }

  altaMatricula(idCurso: Number ,usuario:string){
    return this.http.post(`Matricular?usuario=${usuario}&idCurso=${idCurso}`,null)
  }

  findCursosByAlumno(usuario:string) {
    return this.http.get<Curso[]>(`findCursosByAlumno`, {params: {usuario: usuario}})
  }

  findAlumnosByCursos(nombre:string) {
    return this.http.get<Alumno[]>(`findAlumnosByCurso`, {params: {nombre: nombre}})
  }

}
    //?usuario=${usuario}&password=${password}&nombre=${nombre}&email=${email}&edad=${edad}
/**
 * 
  url:string="http://localhost:4000/15_formacion_matriculas";

  constructor(private http:HttpClient) { }

  findCursos(){
    return this.http.get<Curso[]>(`${this.url}/Cursos`)
  }

  findAlumnos(){
    return this.http.get<Alumno[]>(`${this.url}/Alumnos`)
  }

  consultaMatriculas(start: string, end: string){
    return this.http.get<Matricula[]>(`${this.url}/ConsultaMatriculas`, {params: {start: start, end: end}})
  }

  altaAlumno(usuario:string, password: string, nombre:string ,email:string, edad:Number){
    return this.http.post(`${this.url}/AltaAlumno?usuario=${usuario}&password=${password}&nombre=${nombre}&email=${email}&edad=${edad}`,null)
  }

  altaCurso(nombre:string, duracion: Number, precio:Number ,fechaInicio:string){
    return this.http.post(`${this.url}/AltaCurso?nombre=${nombre}&duracion=${duracion}&precio=${precio}&fechaInicio=${fechaInicio}`,null)
  }

  altaMatricula(idCurso: Number ,usuario:string){
    return this.http.post(`${this.url}/Matricular?usuario=${usuario}&idCurso=${idCurso}`,null)
  }

  findCursosByAlumno(usuario:string) {
    return this.http.get<Curso[]>(`${this.url}/findCursosByAlumno`, {params: {usuario: usuario}})
  }

  findAlumnosByCursos(nombre:string) {
    return this.http.get<Alumno[]>(`${this.url}/findAlumnosByCurso`, {params: {nombre: nombre}})
  }
 */