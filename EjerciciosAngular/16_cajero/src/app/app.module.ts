import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ExtraccionComponent } from './components/Extraccion/Extraccion.component';
import { IngresoComponent } from './components/Ingreso/Ingreso.component';
import { MovimientosComponent } from './components/Movimientos/Movimientos.component';
import { TransferenciaComponent } from './components/Transferencia/Transferencia.component';

@NgModule({
  declarations: [			
    AppComponent,
    IngresoComponent,
    ExtraccionComponent,
    TransferenciaComponent,
    MovimientosComponent
   ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
