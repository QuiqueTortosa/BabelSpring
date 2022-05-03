import { Component, OnInit } from '@angular/core';
import { Curso } from 'src/app/model/Curso';
import { FormacionService } from 'src/app/service/formacion.service';

@Component({
  selector: 'app-AltaCurso',
  templateUrl: './AltaCurso.component.html',
  styleUrls: ['./AltaCurso.component.css']
})
export class AltaCursoComponent implements OnInit {

  nombre: string = "";
  fecha: string = "";
  precio: Number = 0;
  duracion: Number = 0;

  cursosList: Curso[] | undefined;


  constructor(private formacionS: FormacionService) { }

  ngOnInit() {
  }

  altaCurso(){
    this.formacionS.altaCurso(this.nombre,this.duracion,this.precio,this.fecha).subscribe(data => {
      console.log(data)
    })
  }
}
