import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ExtraccionComponent } from './components/Extraccion/Extraccion.component';
import { IngresoComponent } from './components/Ingreso/Ingreso.component';
import { MovimientosComponent } from './components/Movimientos/Movimientos.component';
import { TransferenciaComponent } from './components/Transferencia/Transferencia.component';

const routes: Routes = [
  {path: 'ingresar', component: IngresoComponent},
  {path: 'extraer', component: ExtraccionComponent},
  {path: 'transferir', component: TransferenciaComponent},
  {path: 'movimientos', component: MovimientosComponent}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
