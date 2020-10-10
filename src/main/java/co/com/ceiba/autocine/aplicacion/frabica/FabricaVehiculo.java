package co.com.ceiba.autocine.aplicacion.frabica;

import co.com.ceiba.autocine.aplicacion.comando.ComandoVehiculo;
import co.com.ceiba.autocine.dominio.modelo.Vehiculo;
import org.springframework.stereotype.Component;

@Component
public class FabricaVehiculo {

    public Vehiculo crearVehiculo(ComandoVehiculo comandoVehiculo) {
        return new Vehiculo(
                comandoVehiculo.getId(),
                comandoVehiculo.getPlaca(),
                comandoVehiculo.getIdUsuario()
        );
    }

}
