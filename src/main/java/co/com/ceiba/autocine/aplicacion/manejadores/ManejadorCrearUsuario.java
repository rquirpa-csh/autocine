package co.com.ceiba.autocine.aplicacion.manejadores;

import co.com.ceiba.autocine.aplicacion.comando.ComandoUsuario;
import co.com.ceiba.autocine.aplicacion.frabica.FabricaUsuario;
import co.com.ceiba.autocine.dominio.modelo.Usuario;
import co.com.ceiba.autocine.dominio.servicio.ServicioCrearUsuario;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearUsuario {

    private final ServicioCrearUsuario servicioCrearUsuario;
    private final FabricaUsuario fabricaUsuario;

    public ManejadorCrearUsuario(ServicioCrearUsuario servicioCrearUsuario, FabricaUsuario fabricaUsuario) {
        this.servicioCrearUsuario = servicioCrearUsuario;
        this.fabricaUsuario = fabricaUsuario;
    }

    public Usuario ejecutar(ComandoUsuario comandoUsuario) {
        Usuario usuario = fabricaUsuario.crearUsuario(comandoUsuario);
        return servicioCrearUsuario.ejecutar(usuario);
    }
}
