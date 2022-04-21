import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Producto } from '../model/Producto';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {

  //url:string="http://localhost:4000/05_Tienda_ajax/Buscador"
  url:string="Buscador"
  constructor(private http:HttpClient) { }

  buscar(seccion:string) {
    return this.http.get<Producto[]>(this.url, {params: {seccion: seccion}})
  }

}
