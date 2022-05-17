import { Component } from '@angular/core';
import { Pedido } from './models/Pedido';
import { PedidosService } from './services/pedidos.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  pedidos: Pedido[];

  constructor(private service:PedidosService) {
    this.service.verPedidos().subscribe(data => this.pedidos = data)
  }

}


