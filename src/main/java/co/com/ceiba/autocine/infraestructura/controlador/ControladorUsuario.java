package co.com.ceiba.autocine.infraestructura.controlador;

import co.com.ceiba.autocine.aplicacion.comando.ComandoAcceso;
import co.com.ceiba.autocine.aplicacion.comando.ComandoUsuario;
import co.com.ceiba.autocine.aplicacion.manejadores.ManejadorObtenerUsuario;
import co.com.ceiba.autocine.aplicacion.manejadores.ManejadorCrearUsuario;
import co.com.ceiba.autocine.dominio.modelo.Usuario;
import co.com.ceiba.autocine.infraestructura.security.SecurityUser;
import co.com.ceiba.autocine.infraestructura.security.jwt.JwtUtils;
import co.com.ceiba.autocine.infraestructura.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/usuario")
public class ControladorUsuario extends ControladorBase {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

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
    public void crear(@Valid @RequestBody ComandoUsuario comandoUsuario, Errors errors) {
        validarErrores(errors);
        this.manejadorCrearUsuario.ejecutar(comandoUsuario);
    }

    @GetMapping("/{correo}")
    public Usuario buscarPorCorreo(
            @PathVariable(name = "correo") String correo) {
        return this.manejadorObtenerUsuario.ejecutar(correo);
    }

    @PostMapping("/acceso")
    @ResponseBody
    public SecurityUser acceso(@Valid @RequestBody ComandoAcceso comandoAcceso, Errors errors) {
        validarErrores(errors);
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(comandoAcceso.getCorreo(), comandoAcceso.getContrasena())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        return new SecurityUser(
                userDetails.getId(),
                jwt,
                userDetails.getUsername(),
                userDetails.getNombre(),
                userDetails.getApellido(),
                userDetails.getAuthorities().stream()
                        .map(grantedAuthority -> grantedAuthority.getAuthority())
                        .collect(Collectors.toSet())
        );
    }

}
