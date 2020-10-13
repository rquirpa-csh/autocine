package co.com.ceiba.autocine.infraestructura.security;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class SecurityUser {

    private long id;
    private String token;
    private String correo;
    private String nombre;
    private String apellido;
    private Set<String> roles;

    public SecurityUser(long id, String token, String correo, String nombre, String apellido, Set<String> roles) {
        this.id = id;
        this.token = token;
        this.correo = correo;
        this.nombre = nombre;
        this.apellido = apellido;
        setRoles(roles);
    }


}
