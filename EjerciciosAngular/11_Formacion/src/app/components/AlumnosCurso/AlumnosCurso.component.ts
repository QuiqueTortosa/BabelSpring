import { Component, OnInit } from '@angular/core';
import { Alumno } from 'src/app/model/Alumno';
import { Curso } from 'src/app/model/Curso';
import { FormacionService } from 'src/app/service/formacion.service';

@Component({
  selector: 'app-AlumnosCurso',
  templateUrl: './AlumnosCurso.component.html',
  styleUrls: ['./AlumnosCurso.component.css']
})
export class AlumnosCursoComponent implements OnInit {

  cursosList: Curso[] | undefined;
  alumnosList: Alumno[] | undefined;
  curso: string = "";

  constructor(private formacionS: FormacionService) { }

  ngOnInit() {
    this.formacionS.findCursos().subscribe(data => this.cursosList = data)
  }

  findAlumnosByCursos(usuario: string){
    this.formacionS.findAlumnosByCursos(usuario)
      .subscribe(data => this.alumnosList = data)
  }

}
