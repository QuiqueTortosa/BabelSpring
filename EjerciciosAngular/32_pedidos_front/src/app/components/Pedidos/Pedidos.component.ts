import { Component, OnInit } from '@angular/core';
import { Pedido } from 'src/app/models/Pedido';
import { PedidosService } from 'src/app/services/pedidos.service';

@Component({
  selector: 'app-Pedidos',
  templateUrl: './Pedidos.component.html',
  styleUrls: ['./Pedidos.component.css']
})
export class PedidosComponent implements OnInit {

  pedidos: Pedido[];

  constructor(private service:PedidosService) {

  }

  ngOnInit() {
    this.service.verPedidos().subscribe(data => this.pedidos = data)
  }

  toDate(timestamp: Date){
    let prueba: String = ""+timestamp;
    return prueba.replace("@", " ")
  }

}
