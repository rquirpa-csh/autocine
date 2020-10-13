package co.com.ceiba.autocine.testdatabuilder;

import co.com.ceiba.autocine.aplicacion.comando.ComandoCompra;

public class CompraTestDataBuilder {

    private final long ID_FUNCION = 1;
    private final String PLACA = "ABC-123";
    private final int CANTIDAD_TICKETS = 4;

    private long idFuncion;
    private String placa;
    private int cantidadTickets;

    public CompraTestDataBuilder() {
        this.idFuncion = ID_FUNCION;
        this.placa = PLACA;
        this.cantidadTickets = CANTIDAD_TICKETS;
    }

    public CompraTestDataBuilder conIdFuncion(long idFuncion) {
        this.idFuncion = idFuncion;
        return this;
    }

    public CompraTestDataBuilder conPlaca(String placa) {
        this.placa = placa;
        return this;
    }

    public CompraTestDataBuilder conCantidadTickets(int cantidadTickets) {
        this.cantidadTickets = cantidadTickets;
        return this;
    }

    public ComandoCompra buildComando() {
        return new ComandoCompra(
                this.idFuncion,
                this.placa,
                this.cantidadTickets
        );
    }
}
