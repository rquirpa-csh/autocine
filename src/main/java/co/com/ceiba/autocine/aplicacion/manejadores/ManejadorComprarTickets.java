package co.com.ceiba.autocine.aplicacion.manejadores;

import co.com.ceiba.autocine.aplicacion.comando.ComandoCompra;
import co.com.ceiba.autocine.dominio.modelo.Factura;
import co.com.ceiba.autocine.dominio.servicio.ServicioComprarTickets;
import org.springframework.stereotype.Component;

@Component
public class ManejadorComprarTickets {

    private final ServicioComprarTickets servicioComprarTickets;

    public ManejadorComprarTickets(ServicioComprarTickets servicioComprarTickets) {
        this.servicioComprarTickets = servicioComprarTickets;
    }

    public Factura ejecutar(long idUsuario, ComandoCompra comandoCompra) {
        return servicioComprarTickets.ejecutar(
                idUsuario,
                comandoCompra.getIdFuncion(),
                comandoCompra.getPlaca(),
                comandoCompra.getCantidadTickets());
    }

}
