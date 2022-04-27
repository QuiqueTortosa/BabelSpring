import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AlumnosCursoComponent } from './components/AlumnosCurso/AlumnosCurso.component';
import { CursosAlumnoComponent } from './components/CursosAlumno/CursosAlumno.component';

const routes: Routes = [
  {path: 'alumnosCurso', component: AlumnosCursoComponent},
  {path: 'cursosAlumno', component: CursosAlumnoComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
