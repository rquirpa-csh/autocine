package co.com.ceiba.autocine.dominio.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Factura {

    private long id;
    private int numeroEntradas;
    private double subtotal;
    private double porcentajeDescuento;
    private double descuento;
    private double total;
    private LocalDateTime fechaCompra;
    private Funcion funcion;
    private Vehiculo vehiculo;

}
