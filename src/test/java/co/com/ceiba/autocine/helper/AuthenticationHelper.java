package co.com.ceiba.autocine.helper;

import co.com.ceiba.autocine.infraestructura.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationHelper {

    public static final String CORREO_ADMINISTRADOR = "roberto.quirpa@gmail.com";
    public static final String CONTRASENA_ADMINISTRADOR = "12345";

    public static final String CORREO_USUARIO = "maria.dolores@gmail.com";
    public static final String CONTRASENA_USUARIO = "12345";

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    public String authenticate(String correo, String contrasena) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(correo, contrasena)
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return jwtUtils.generateJwtToken(authentication);
    }

}
