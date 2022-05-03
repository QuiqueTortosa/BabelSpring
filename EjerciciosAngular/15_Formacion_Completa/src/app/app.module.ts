import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AlumnosCursoComponent } from './components/AlumnosCurso/AlumnosCurso.component';
import { CursosAlumnoComponent } from './components/CursosAlumno/CursosAlumno.component';
import { FormsModule } from '@angular/forms';
import { AltaAlumnoComponent } from './components/AltaAlumno/AltaAlumno.component';
import { AltaCursoComponent } from './components/AltaCurso/AltaCurso.component';
import { AltaMatriculaComponent } from './components/AltaMatricula/AltaMatricula.component';
import { BuscarMatriculasComponent } from './components/BuscarMatriculas/BuscarMatriculas.component';


@NgModule({
  declarations: [
    AppComponent,
    AlumnosCursoComponent,
    CursosAlumnoComponent,
    AltaAlumnoComponent,
    AltaCursoComponent,
    AltaMatriculaComponent,
    BuscarMatriculasComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
