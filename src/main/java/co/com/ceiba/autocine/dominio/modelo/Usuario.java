package co.com.ceiba.autocine.dominio.modelo;

import co.com.ceiba.autocine.dominio.exception.ApplicationException;
import co.com.ceiba.autocine.utils.StringUtils;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
public class Usuario {

    public static final String ERROR_ID = "El id de usuario deber ser positivo";
    public static final String ERROR_NOMBRE = "El nombre es obligatorio";
    public static final String ERROR_APELLIDO = "El apellido es obligatorio";
    public static final String ERROR_TIPO_DOCUMENTO = "El tipo de documento es obligatorio";
    public static final String ERROR_ID_DOCUMENTO = "El id de documento es obligatorio";
    public static final String ERROR_CONTRASENA = "La contraseña es obligatoria";
    public static final String ERROR_ROLES = "Debe tener al menos un rol asignado";

    private long id;
    private String nombre;
    private String apellido;
    private int tipoDocumento;
    private long idDocumento;
    private String contrasena;
    private Set<Rol> roles;

    public Usuario(long id, String nombre, String apellido, int tipoDocumento, long idDocumento, String contrasena, Set<Rol> roles) {
        setId(id);
        setNombre(nombre);
        setApellido(apellido);
        setTipoDocumento(tipoDocumento);
        setIdDocumento(idDocumento);
        setContrasena(contrasena);
        setRoles(roles);
    }

    public void setId(long id) {
        if (id < 0) {
            throw new ApplicationException(ERROR_ID);
        }
        this.id = id;
    }

    public void setNombre(String nombre) {
        if (StringUtils.isNullOrEmpty(nombre)) {
            throw new ApplicationException(ERROR_NOMBRE);
        }
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        if (StringUtils.isNullOrEmpty(apellido)) {
            throw new ApplicationException(ERROR_APELLIDO);
        }
        this.apellido = apellido;
    }

    public void setTipoDocumento(int tipoDocumento) {
        if (tipoDocumento <= 0) {
            throw new ApplicationException(ERROR_TIPO_DOCUMENTO);
        }
        this.tipoDocumento = tipoDocumento;
    }

    public void setIdDocumento(long idDocumento) {
        if (idDocumento <= 0) {
            throw new ApplicationException(ERROR_ID_DOCUMENTO);
        }
        this.idDocumento = idDocumento;
    }

    public void setContrasena(String contrasena) {
        if (StringUtils.isNullOrEmpty(contrasena)) {
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
