import { Component, OnInit } from '@angular/core';
import { Matricula } from 'src/app/model/Matricula';
import { FormacionService } from 'src/app/service/formacion.service';

@Component({
  selector: 'app-BuscarMatriculas',
  templateUrl: './BuscarMatriculas.component.html',
  styleUrls: ['./BuscarMatriculas.component.css']
})
export class BuscarMatriculasComponent implements OnInit {

  start: string = ""
  end: string = ""

  matriculasList: Matricula[] | undefined;

  constructor(private formacionS: FormacionService) { }

  ngOnInit() {
  }

  buscarMatricula() {
    this.formacionS.consultaMatriculas(this.start, this.end).subscribe(data => this.matriculasList = data)
  }

  toDatee(timestamp: Date){
    let date: Date = new Date(Number(timestamp));  
    return date.getDate()+"/"+(date.getMonth()+1)+"/"+date.getFullYear();
  }

}
