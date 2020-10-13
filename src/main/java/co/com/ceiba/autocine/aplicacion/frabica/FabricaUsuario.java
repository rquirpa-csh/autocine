package co.com.ceiba.autocine.aplicacion.frabica;

import co.com.ceiba.autocine.aplicacion.comando.ComandoUsuario;
import co.com.ceiba.autocine.dominio.modelo.Rol;
import co.com.ceiba.autocine.dominio.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Set;

@Component
public class FabricaUsuario {

    @Autowired
    private PasswordEncoder encoder;

    public Usuario crearUsuario(ComandoUsuario comandoUsuario) {
        Set<Rol> roles = new HashSet<>();
        roles.add(new Rol(Rol.ROL_USUARIO, null));

        String encodePass = null;
        if (!StringUtils.isEmpty(comandoUsuario.getContrasena())) {
            encodePass = encoder.encode(comandoUsuario.getContrasena());
        }

        return new Usuario(
                comandoUsuario.getId(),
                comandoUsuario.getCorreo(),
                comandoUsuario.getNombre(),
                comandoUsuario.getApellido(),
                encodePass,
                roles
        );
    }

}
