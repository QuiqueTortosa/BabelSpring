import { Component, OnInit } from '@angular/core';
import { Curso } from 'src/app/model/Curso';
import { FormacionService } from 'src/app/service/formacion.service';

@Component({
  selector: 'app-AltaAlumno',
  templateUrl: './AltaAlumno.component.html',
  styleUrls: ['./AltaAlumno.component.css']
})
export class AltaAlumnoComponent implements OnInit {

  usuario: string = "";
  password: string = "";
  nombre: string = "";
  email: string = "";
  edad: Number = 0;

  cursosList: Curso[] | undefined;


  constructor(private formacionS: FormacionService) { }

  ngOnInit() {
  }

  altaAlumno(){
    this.formacionS.altaAlumno(this.usuario,this.password,this.nombre,this.email,this.edad).subscribe(data2 => {
      console.log(data2)
    })
  }
}
