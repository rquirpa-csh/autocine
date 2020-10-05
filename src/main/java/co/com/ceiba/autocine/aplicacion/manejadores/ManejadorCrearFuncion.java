package co.com.ceiba.autocine.aplicacion.manejadores;

import co.com.ceiba.autocine.aplicacion.comando.ComandoFuncion;
import co.com.ceiba.autocine.aplicacion.frabica.FabricaFuncion;
import co.com.ceiba.autocine.dominio.modelo.Funcion;
import co.com.ceiba.autocine.dominio.servicio.ServicioCrearFuncion;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearFuncion {

    private final ServicioCrearFuncion servicioCrearFuncion;
    private final FabricaFuncion fabricafuncion;

    public ManejadorCrearFuncion(ServicioCrearFuncion servicioCrearFuncion, FabricaFuncion fabricafuncion) {
        this.servicioCrearFuncion = servicioCrearFuncion;
        this.fabricafuncion = fabricafuncion;
    }

    public Funcion ejecutar(ComandoFuncion comandoFuncion) {
        Funcion funcion = this.fabricafuncion.crearFuncion(comandoFuncion);
        return this.servicioCrearFuncion.ejecutar(funcion);
    }

}
