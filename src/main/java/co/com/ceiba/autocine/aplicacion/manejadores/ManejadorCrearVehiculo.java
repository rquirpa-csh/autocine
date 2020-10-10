package co.com.ceiba.autocine.aplicacion.manejadores;

import co.com.ceiba.autocine.aplicacion.comando.ComandoVehiculo;
import co.com.ceiba.autocine.aplicacion.frabica.FabricaVehiculo;
import co.com.ceiba.autocine.dominio.modelo.Vehiculo;
import co.com.ceiba.autocine.dominio.servicio.ServicioCrearVehiculo;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearVehiculo {

    private final ServicioCrearVehiculo servicioCrearVehiculo;
    private final FabricaVehiculo fabricaVehiculo;

    public ManejadorCrearVehiculo(ServicioCrearVehiculo servicioCrearVehiculo, FabricaVehiculo fabricaVehiculo) {
        this.servicioCrearVehiculo = servicioCrearVehiculo;
        this.fabricaVehiculo = fabricaVehiculo;
    }

    public Vehiculo ejecutar(ComandoVehiculo comandoVehiculo) {
        Vehiculo vehiculo = fabricaVehiculo.crearVehiculo(comandoVehiculo);
        return servicioCrearVehiculo.ejecutar(vehiculo);
    }

}
