package co.com.ceiba.autocine.aplicacion.frabica;

import co.com.ceiba.autocine.aplicacion.comando.ComandoUsuario;
import co.com.ceiba.autocine.dominio.modelo.Usuario;
import org.springframework.stereotype.Component;

@Component
public class FabricaUsuario {

    public Usuario crearUsuario(ComandoUsuario comandoUsuario) {
        return new Usuario(
                comandoUsuario.getId(),
                comandoUsuario.getNombre(),
                comandoUsuario.getApellido(),
                comandoUsuario.getTipoDocumento(),
                comandoUsuario.getIdDocumento(),
                comandoUsuario.getContrasena(),
                comandoUsuario.getRoles()
        );
    }

}
