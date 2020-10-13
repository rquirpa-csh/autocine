package co.com.ceiba.autocine.infraestructura.controlador;

import co.com.ceiba.autocine.aplicacion.comando.ComandoVehiculo;
import co.com.ceiba.autocine.aplicacion.manejadores.ManejadorCrearVehiculo;
import co.com.ceiba.autocine.aplicacion.manejadores.ManejadorObtenerVehiculo;
import co.com.ceiba.autocine.dominio.modelo.Vehiculo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/vehiculo")
@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
public class ControladorVehiculo extends ControladorBase {

    private final ManejadorCrearVehiculo manejadorCrearVehiculo;
    private final ManejadorObtenerVehiculo manejadorObtenerVehiculo;

    public ControladorVehiculo(ManejadorCrearVehiculo manejadorCrearVehiculo, ManejadorObtenerVehiculo manejadorObtenerVehiculo) {
        this.manejadorCrearVehiculo = manejadorCrearVehiculo;
        this.manejadorObtenerVehiculo = manejadorObtenerVehiculo;
    }

    @PostMapping
    public Vehiculo crear(@RequestBody ComandoVehiculo comandoVehiculo) {
        return manejadorCrearVehiculo.ejecutar(comandoVehiculo);
    }

    @GetMapping("/placa/{placa}")
    public Vehiculo obtenerPorPlaca(@PathVariable(name = "placa") String placa) {
        return manejadorObtenerVehiculo.obtenerPorPlaca(placa);
    }

    @GetMapping("/usuario/{idUsuario}")
    public Set<Vehiculo> obtenerPorIdUsuario(@PathVariable(name = "idUsuario") long idUsuario) {
        return manejadorObtenerVehiculo.obtenerPorIdUsuario(idUsuario);
    }

}
