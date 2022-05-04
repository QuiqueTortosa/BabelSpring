import { Component, OnInit } from '@angular/core';
import { Cuenta } from 'src/app/model/Cuenta';
import { Movimiento } from 'src/app/model/Movimiento';
import { CajeroService } from 'src/app/services/cajero.service';

@Component({
  selector: 'app-Movimientos',
  templateUrl: './Movimientos.component.html',
  styleUrls: ['./Movimientos.component.css']
})
export class MovimientosComponent implements OnInit {

  start: string = ""
  end: string = ""

  movimientoList: Movimiento[] | undefined;
  cuenta: Cuenta = null;

  constructor(private cajeroS: CajeroService) { }

  ngOnInit() {
    this.cajeroS.verCuenta().subscribe(data => this.cuenta = data)
  }

  buscarMovimientos() {
    this.cajeroS.verMovimientos(this.start, this.end).subscribe(data => this.movimientoList = data)
  }

  toDatee(timestamp: Date){
    let date: Date = new Date(Number(timestamp));  
    return date.getUTCFullYear() +
    '-' + ('0' + date.getUTCMonth()).slice(-2) +
    '-' + ('0' + date.getUTCDate()).slice(-2) + 
    ' ' + ('0' + date.getUTCHours()).slice(-2) +
    ':' + ('0' + date.getUTCMinutes()).slice(-2) +
    ':' + ('0' + date.getUTCSeconds()).slice(-2)
  }

}
