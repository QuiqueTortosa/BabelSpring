import { Component, OnInit } from '@angular/core';
import { CajeroService } from 'src/app/services/cajero.service';

@Component({
  selector: 'app-Extraccion',
  templateUrl: './Extraccion.component.html',
  styleUrls: ['./Extraccion.component.css']
})
export class ExtraccionComponent implements OnInit {

  cantidad:Number = 0
  mensaje: String = ""

  constructor(private cajeroS: CajeroService) { }

  ngOnInit() {
  }

  extraccion(){ 
    this.mensaje = "Dinero extraido"
    this.cajeroS.extraccion(this.cantidad).subscribe(data => {
      console.log(data)
    })
  }

}

