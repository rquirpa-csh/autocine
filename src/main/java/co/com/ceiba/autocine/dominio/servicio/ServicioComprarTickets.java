package co.com.ceiba.autocine.dominio.servicio;

import co.com.ceiba.autocine.dominio.modelo.Factura;
import co.com.ceiba.autocine.dominio.modelo.Funcion;
import co.com.ceiba.autocine.dominio.modelo.Vehiculo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServicioComprarTickets {

    private final ServicioValidarFuncionCompra servicioValidarFuncionCompra;
    private final ServicioValidarVehiculoCompra servicioValidarVehiculoCompra;
    private final ServicioCrearFactura servicioCrearFactura;

    public ServicioComprarTickets(ServicioValidarFuncionCompra servicioValidarFuncionCompra,
                                  ServicioValidarVehiculoCompra servicioValidarVehiculoCompra,
                                  ServicioCrearFactura servicioCrearFactura) {
        this.servicioValidarFuncionCompra = servicioValidarFuncionCompra;
        this.servicioValidarVehiculoCompra = servicioValidarVehiculoCompra;
        this.servicioCrearFactura = servicioCrearFactura;
    }

    @Transactional
    public Factura ejecutar(long idUsuario, long idFuncion, String placa, int cantidadTickets) {
        Funcion funcion = servicioValidarFuncionCompra.ejecutar(idFuncion);
        Vehiculo vehiculo = servicioValidarVehiculoCompra.ejecutar(funcion, idUsuario, placa);
        return servicioCrearFactura.ejecutar(funcion, vehiculo, cantidadTickets);
    }

}
