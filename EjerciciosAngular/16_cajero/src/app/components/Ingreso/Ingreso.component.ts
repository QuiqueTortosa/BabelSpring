import { Component, OnInit } from '@angular/core';
import { CajeroService } from 'src/app/services/cajero.service';

@Component({
  selector: 'app-Ingreso',
  templateUrl: './Ingreso.component.html',
  styleUrls: ['./Ingreso.component.css']
})
export class IngresoComponent implements OnInit {

  cantidad:Number = 0
  mensaje: String = ""

  constructor(private cajeroS: CajeroService) { }

  ngOnInit() {
  }

  ingresar(){ 
    this.mensaje = "Dinero ingresado"
    this.cajeroS.ingreso(this.cantidad).subscribe(data => {
      console.log(data)
    })
  }

}
