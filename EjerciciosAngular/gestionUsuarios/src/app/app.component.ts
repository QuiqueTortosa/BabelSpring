import { Component } from '@angular/core';
import { Alumno } from './model/Alumno';
import { AlumnoService } from './service/alumno.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  curso: string
  ListCurso: string[];
  alumnos: Alumno[]

  constructor(private service:AlumnoService) {
    this.service.getCursos().subscribe(data => this.ListCurso = data)
  }

  busqueda(curso:string) {
    this.service.buscar(curso)
      .subscribe(data => this.alumnos = data)
  }


}
