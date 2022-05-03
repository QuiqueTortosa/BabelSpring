import { Component, OnInit } from '@angular/core';
import { Alumno } from 'src/app/model/Alumno';
import { Curso } from 'src/app/model/Curso';
import { FormacionService } from 'src/app/service/formacion.service';

@Component({
  selector: 'app-AltaMatricula',
  templateUrl: './AltaMatricula.component.html',
  styleUrls: ['./AltaMatricula.component.css']
})
export class AltaMatriculaComponent implements OnInit {

  idCurso: Number = 0;
  usuario:string = ""

  cursosList: Curso[] | undefined;
  alumnosList: Alumno[] | undefined;

  constructor(private formacionS: FormacionService) { }

  ngOnInit() {
    this.formacionS.findCursos().subscribe(data => this.cursosList = data )
    this.formacionS.findAlumnos().subscribe(data => this.alumnosList = data)

  }

  altaMatricula(){
    console.log(this.idCurso)
    console.log(this.usuario)
    this.formacionS.altaMatricula(this.idCurso, this.usuario).subscribe(data => console.log(data))
  }


}
