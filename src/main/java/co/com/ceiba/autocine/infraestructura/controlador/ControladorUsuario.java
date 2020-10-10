package co.com.ceiba.autocine.infraestructura.controlador;

import co.com.ceiba.autocine.aplicacion.comando.ComandoUsuario;
import co.com.ceiba.autocine.aplicacion.manejadores.ManejadorObtenerUsuario;
import co.com.ceiba.autocine.aplicacion.manejadores.ManejadorCrearUsuario;
import co.com.ceiba.autocine.dominio.modelo.Usuario;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuario")
public class ControladorUsuario {

    private final ManejadorCrearUsuario manejadorCrearUsuario;
    private final ManejadorObtenerUsuario manejadorObtenerUsuario;

    public ControladorUsuario(
            ManejadorCrearUsuario manejadorCrearUsuario,
            ManejadorObtenerUsuario manejadorObtenerUsuario
    ) {
        this.manejadorCrearUsuario = manejadorCrearUsuario;
        this.manejadorObtenerUsuario = manejadorObtenerUsuario;
    }

    @PostMapping
    public void crear(@RequestBody ComandoUsuario comandoUsuario) {
        this.manejadorCrearUsuario.ejecutar(comandoUsuario);
    }

    @GetMapping("/{tipoDocumento}/{idDocumento}")
    public Usuario buscarPorDocumento(
            @PathVariable(name = "tipoDocumento") int tipoDocumento,
            @PathVariable(name = "idDocumento") long idDocumento) {
        return this.manejadorObtenerUsuario.ejecutar(tipoDocumento, idDocumento);
    }

}
