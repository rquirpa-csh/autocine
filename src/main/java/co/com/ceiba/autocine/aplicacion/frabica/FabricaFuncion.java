package co.com.ceiba.autocine.aplicacion.frabica;

import co.com.ceiba.autocine.aplicacion.comando.ComandoFuncion;
import co.com.ceiba.autocine.dominio.modelo.Funcion;
import org.springframework.stereotype.Component;

@Component
public class FabricaFuncion {

    public Funcion crearFuncion(ComandoFuncion funcion) {
        return new Funcion(
                funcion.getId(),
                funcion.getNombre(),
                funcion.getFechaInicio(),
                funcion.getFechaFin(),
                funcion.getCapacidadTotal(),
                funcion.getCapacidadDisponible(),
                funcion.getCosto()
        );
    }
}
