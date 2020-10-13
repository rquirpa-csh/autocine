package co.com.ceiba.autocine.infraestructura.controlador;

import co.com.ceiba.autocine.aplicacion.comando.ComandoCompra;
import co.com.ceiba.autocine.aplicacion.comando.ComandoFuncion;
import co.com.ceiba.autocine.aplicacion.manejadores.ManejadorComprarTickets;
import co.com.ceiba.autocine.aplicacion.manejadores.ManejadorCrearFuncion;
import co.com.ceiba.autocine.aplicacion.manejadores.ManejadorObtenerFuncion;
import co.com.ceiba.autocine.dominio.modelo.Factura;
import co.com.ceiba.autocine.dominio.modelo.Funcion;
import co.com.ceiba.autocine.infraestructura.security.services.UserDetailsImpl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/funcion")
public class ControladorFuncion extends ControladorBase {

    private final ManejadorCrearFuncion manejadorCrearFuncion;
    private final ManejadorObtenerFuncion manejadorObtenerFuncion;
    private final ManejadorComprarTickets manejadorComprarTickets;

    public ControladorFuncion(
            ManejadorCrearFuncion manejadorCrearFuncion,
            ManejadorObtenerFuncion manejadorObtenerFuncion,
            ManejadorComprarTickets manejadorComprarTickets) {
        this.manejadorCrearFuncion = manejadorCrearFuncion;
        this.manejadorObtenerFuncion = manejadorObtenerFuncion;
        this.manejadorComprarTickets = manejadorComprarTickets;
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Funcion crear(@Valid @RequestBody ComandoFuncion comandoFuncion, Errors errors) {
        validarErrores(errors);
        return this.manejadorCrearFuncion.ejecutar(comandoFuncion);
    }

    @GetMapping("/{fechaInicio}/{fechaFin}")
    public Set<Funcion> buscarPorFecha(
            @PathVariable(name = "fechaInicio") String fechaInicio,
            @PathVariable(name = "fechaFin") String fechaFin) {
        return this.manejadorObtenerFuncion.buscarPorFecha(
                LocalDateTime.parse(fechaInicio),
                LocalDateTime.parse(fechaFin));
    }

    @PostMapping("/comprar")
    @PreAuthorize("hasRole('USER')")
    public Factura comprarTickets(@Valid @RequestBody ComandoCompra comandoCompra, Errors errors) {
        validarErrores(errors);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return this.manejadorComprarTickets.ejecutar(userDetails.getId(), comandoCompra);
    }

}
