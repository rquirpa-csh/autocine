package co.com.ceiba.autocine.infraestructura.controlador;

import co.com.ceiba.autocine.aplicacion.comando.ComandoFuncion;
import co.com.ceiba.autocine.aplicacion.manejadores.ManejadorCrearFuncion;
import co.com.ceiba.autocine.dominio.modelo.Funcion;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/funcion")
public class ControladorFuncion {

    private final ManejadorCrearFuncion manejadorCrearFuncion;

    public ControladorFuncion(ManejadorCrearFuncion manejadorCrearFuncion) {
        this.manejadorCrearFuncion = manejadorCrearFuncion;
    }

    @PostMapping
    public Funcion crear(@RequestBody ComandoFuncion comandoFuncion) {
        return this.manejadorCrearFuncion.ejecutar(comandoFuncion);
    }
}
