import { Component } from '@angular/core';
import { Producto } from './model/Producto';
import { ProductoService } from './service/producto.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  
  seccion: string;
  productos: Producto[]

  constructor(private service:ProductoService) {

  }

  busqueda() {
    this.service.buscar(this.seccion)
      .subscribe(data => this.productos = data)
  }

}
