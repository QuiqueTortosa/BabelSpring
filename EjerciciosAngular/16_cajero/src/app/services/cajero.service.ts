import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Movimiento } from '../model/Movimiento';
import { Cuenta } from '../model/Cuenta';

@Injectable({
  providedIn: 'root'
})
export class CajeroService {

  //url:string="http://localhost:4000/16_cajero";

  constructor(private http:HttpClient) { }

  login(nmCuenta: Number) {
    return this.http.post<string>(`Cuenta?nmCuenta=${nmCuenta}`,null);
  }

  ingreso(cantidad: Number){
    return this.http.post<boolean>(`Ingreso?cantidad=${cantidad}`,null);
  }

  extraccion(cantidad: Number){
    return this.http.post<boolean>(`Extracto?cantidad=${cantidad}`,null);
  }

  transferencia(toNmCuenta: Number, cantidad: Number){
    return this.http.post<boolean>(`Transferencia?toNmCuenta=${toNmCuenta}&cantidad=${cantidad}`,null);
  }

  verMovimientos(start: string, end: string){
    return this.http.get<Movimiento []>(`ConsultaMovimientos`,{params: {start: start, end: end}});
  }

  verCuenta(){
    return this.http.get<Cuenta>(`Cuenta`);
  }


}
