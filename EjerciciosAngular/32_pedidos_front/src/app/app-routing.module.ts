import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HacerPedidoComponent } from './components/HacerPedido/HacerPedido.component';
import { PedidosComponent } from './components/Pedidos/Pedidos.component';

const routes: Routes = [
  {path: 'hacerPedido', component: HacerPedidoComponent},
  {path: 'verPedidos', component: PedidosComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
