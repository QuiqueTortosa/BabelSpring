import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Pedido } from '../models/Pedido';
import { Producto } from '../models/Producto';

@Injectable({
  providedIn: 'root'
})
export class PedidosService {

  url:string="http://localhost:10000";

  constructor(private http:HttpClient) { }

  verPedidos(){
    return this.http.get<Pedido []>(`${this.url}/spedidos/`);
  }

  verProductos(){
    return this.http.get<Producto []>(`${this.url}/sproductos/`);
  }

  confirmarPedido(codigoProducto: Number, unidades: Number){
    return this.http.post<boolean>(`${this.url}/spedidos/`, {
      codigoProducto: codigoProducto,
      unidades: unidades
    });
  }
}
