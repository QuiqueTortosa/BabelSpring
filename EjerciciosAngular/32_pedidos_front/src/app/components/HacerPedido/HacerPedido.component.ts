import { Component, OnInit } from '@angular/core';
import { Producto } from 'src/app/models/Producto';
import { PedidosService } from 'src/app/services/pedidos.service';

@Component({
  selector: 'app-HacerPedido',
  templateUrl: './HacerPedido.component.html',
  styleUrls: ['./HacerPedido.component.css']
})
export class HacerPedidoComponent implements OnInit {

  productos: Producto[];

  productoSeleccionado: Producto | null;

  unidades: Number = 0;

  realizado: boolean = false;

  constructor(private service:PedidosService) { }

  ngOnInit() {
    this.service.verProductos().subscribe(data => this.productos = data)
  }

  resultados(){
    this.service.confirmarPedido(this.productoSeleccionado.codigoProducto, this.unidades).subscribe(data => console.log(data))
    this.realizado = true
  }

}
