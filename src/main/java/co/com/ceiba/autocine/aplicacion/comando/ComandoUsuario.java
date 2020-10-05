package co.com.ceiba.autocine.aplicacion.comando;

import co.com.ceiba.autocine.dominio.modelo.Rol;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class ComandoUsuario {

    private long id;
    private String nombre;
    private String apellido;
    private int tipoDocumento;
    private long idDocumento;
    private String contrasena;
    private Set<Rol> roles;

    public ComandoUsuario(long id, String nombre, String apellido, int tipoDocumento, long idDocumento, String contrasena, Set<Rol> roles) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDocumento = tipoDocumento;
        this.idDocumento = idDocumento;
        this.contrasena = contrasena;
        this.roles = new HashSet<>(roles);
    }

}
