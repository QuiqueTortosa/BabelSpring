import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AlumnosCursoComponent } from './components/AlumnosCurso/AlumnosCurso.component';
import { CursosAlumnoComponent } from './components/CursosAlumno/CursosAlumno.component';
import { AltaAlumnoComponent } from './components/AltaAlumno/AltaAlumno.component';
import { AltaCursoComponent } from './components/AltaCurso/AltaCurso.component';
import { AltaMatriculaComponent } from './components/AltaMatricula/AltaMatricula.component';
import { BuscarMatriculasComponent } from './components/BuscarMatriculas/BuscarMatriculas.component';

const routes: Routes = [
  {path: 'alumnosCurso', component: AlumnosCursoComponent},
  {path: 'cursosAlumno', component: CursosAlumnoComponent},
  {path: 'altaAlumno', component: AltaAlumnoComponent},
  {path: 'altaCurso', component: AltaCursoComponent},
  {path: 'altaMatricula', component: AltaMatriculaComponent},
  {path: 'buscarMatricula', component: BuscarMatriculasComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
