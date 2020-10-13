package co.com.ceiba.autocine.dominio.modelo;

import co.com.ceiba.autocine.dominio.exception.ApplicationException;
import lombok.Getter;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Set;

@Getter
public class Usuario {

    public static final String ERROR_ID = "El id de usuario deber ser positivo";
    public static final String ERROR_NOMBRE = "El nombre es obligatorio";
    public static final String ERROR_APELLIDO = "El apellido es obligatorio";
    public static final String ERROR_CONTRASENA = "La contraseña es obligatoria";
    public static final String ERROR_ROLES = "Debe tener al menos un rol asignado";
    public static final String ERROR_CORREO = "El correo es obligatorio";

    private long id;
    private String correo;
    private String nombre;
    private String apellido;
    private String contrasena;
    private Set<Rol> roles;

    public Usuario(long id, String correo, String nombre, String apellido, String contrasena, Set<Rol> roles) {
        setId(id);
        setNombre(nombre);
        setApellido(apellido);
        setCorreo(correo);
        setContrasena(contrasena);
        setRoles(roles);
    }

    public void setId(long id) {
        if (id < 0) {
            throw new ApplicationException(ERROR_ID);
        }
        this.id = id;
    }

    public void setCorreo(String correo) {
        if (correo == null) {
            throw new ApplicationException(ERROR_CORREO);
        }
        this.correo = correo;
    }

    public void setNombre(String nombre) {
        if (StringUtils.isEmpty(nombre)) {
            throw new ApplicationException(ERROR_NOMBRE);
        }
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        if (StringUtils.isEmpty(apellido)) {
            throw new ApplicationException(ERROR_APELLIDO);
        }
        this.apellido = apellido;
    }

    public void setContrasena(String contrasena) {
        if (StringUtils.isEmpty(contrasena)) {
            throw new ApplicationException(ERROR_CONTRASENA);
        }
        this.contrasena = contrasena;
    }

    public void setRoles(Set<Rol> roles) {
        if (roles == null || roles.isEmpty()) {
            throw new ApplicationException(ERROR_ROLES);
        }
        this.roles = new HashSet<>(roles);
    }

}
