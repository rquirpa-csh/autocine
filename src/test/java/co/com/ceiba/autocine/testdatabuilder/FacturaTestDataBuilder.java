package co.com.ceiba.autocine.testdatabuilder;

import co.com.ceiba.autocine.dominio.modelo.Factura;
import co.com.ceiba.autocine.dominio.modelo.Funcion;
import co.com.ceiba.autocine.dominio.modelo.Vehiculo;

import java.time.LocalDateTime;

public class FacturaTestDataBuilder {

    private static final int ID = 1;
    private static final int NUMERO_ENTRADAS = 1;
    private static final double SUBTOTAL = 10000;
    private static final double PORCENTAJE_DESCUENTO = 0.1;
    private static final double DESCUENTO = 1000;
    private static final double TOTAL = 9000;
    private static final LocalDateTime FECHA_COMPRAR = LocalDateTime.parse("2020-10-05T14:00:00");

    private long id;
    private int numeroEntradas;
    private double subtotal;
    private double porcentajeDescuento;
    private double descuento;
    private double total;
    private LocalDateTime fechaCompra;
    private Funcion funcion;
    private Vehiculo vehiculo;

    public FacturaTestDataBuilder() {
        this.id = ID;
        this.numeroEntradas = NUMERO_ENTRADAS;
        this.subtotal = SUBTOTAL;
        this.porcentajeDescuento = PORCENTAJE_DESCUENTO;
        this.descuento = DESCUENTO;
        this.total = TOTAL;
    }

    public FacturaTestDataBuilder conId(long id) {
        this.id = id;
        return this;
    }

    public FacturaTestDataBuilder conNumeroEntradas(int numeroEntradas) {
        this.numeroEntradas = numeroEntradas;
        return this;
    }

    public FacturaTestDataBuilder conSubtotal(double subtotal) {
        this.subtotal = subtotal;
        return this;
    }

    public FacturaTestDataBuilder conPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
        return this;
    }

    public FacturaTestDataBuilder conDescuento(double descuento) {
        this.descuento = descuento;
        return this;
    }

    public FacturaTestDataBuilder conTotal(double total) {
        this.total = total;
        return this;
    }

    public FacturaTestDataBuilder conFechaCompra(LocalDateTime fechaCompra) {
        this.fechaCompra = fechaCompra;
        return this;
    }

    public FacturaTestDataBuilder conFuncion(Funcion funcion) {
        this.funcion = funcion;
        return this;
    }

    public FacturaTestDataBuilder conVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
        return this;
    }

    public Factura build() {
        return new Factura(
                this.id,
                this.numeroEntradas,
                this.subtotal,
                this.porcentajeDescuento,
                this.descuento,
                this.total,
                this.fechaCompra,
                this.funcion,
                this.vehiculo
        );
    }

}
