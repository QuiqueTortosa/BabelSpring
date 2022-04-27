import { Component, OnInit } from '@angular/core';
import { Curso } from 'src/app/model/Curso';
import { Alumno } from 'src/app/model/Alumno';
import { FormacionService } from 'src/app/service/formacion.service';

@Component({
  selector: 'app-CursosAlumno',
  templateUrl: './CursosAlumno.component.html',
  styleUrls: ['./CursosAlumno.component.css']
})
export class CursosAlumnoComponent implements OnInit {

  cursosList: Curso[] | undefined;
  alumnosList: Alumno[] | undefined;
  alumno: string = "";

  constructor(private formacionS: FormacionService) { }

  ngOnInit() {
    this.formacionS.findAlumnos().subscribe(data => this.alumnosList = data)
  }

  findCursosByAlumno(usuario: string){
    this.formacionS.findCursosByAlumno(usuario)
      .subscribe(data => this.cursosList = data)
  }
}
