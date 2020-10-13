package co.com.ceiba.autocine.dominio.repositorio;

import co.com.ceiba.autocine.dominio.modelo.Factura;

import java.time.LocalDateTime;

public interface RepositorioFactura {

    Factura crear(Factura factura);

    Factura obtenerPorIdVehiculoYIdFuncion(long idVehiculo, long idFuncion);

    int buscarPorIdVehiculoIdFechaComprar(long idVehiculo, LocalDateTime fechaCompra);

}
