import { Component, OnInit } from '@angular/core';
import { Cuenta } from 'src/app/model/Cuenta';
import { CajeroService } from 'src/app/services/cajero.service';

@Component({
  selector: 'app-Transferencia',
  templateUrl: './Transferencia.component.html',
  styleUrls: ['./Transferencia.component.css']
})
export class TransferenciaComponent implements OnInit {

  nmCuenta:Number = 0
  cantidad:Number = 0
  mensaje: String = ""

  constructor(private cajeroS: CajeroService) { }

  ngOnInit() {
  }

  transferir(){ 
    this.mensaje = "Dinero extraido"
    this.cajeroS.transferencia(this.nmCuenta,this.cantidad).subscribe(data => {
      console.log(data)
    })
  }

}
