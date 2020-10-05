package co.com.ceiba.autocine.infraestructura.controlador;

import co.com.ceiba.autocine.aplicacion.comando.ComandoUsuario;
import co.com.ceiba.autocine.aplicacion.manejadores.ManejadorCrearUsuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/usuario")
public class ControladorUsuario {

    private final ManejadorCrearUsuario manejadorCrearUsuario;

    public ControladorUsuario(ManejadorCrearUsuario manejadorCrearUsuario) {
        this.manejadorCrearUsuario = manejadorCrearUsuario;
    }

    @PostMapping
    public void crear(@RequestBody ComandoUsuario comandoUsuario) {
        this.manejadorCrearUsuario.ejecutar(comandoUsuario);
    }

}
