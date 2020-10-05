package co.com.ceiba.autocine.aplicacion.comando;

import co.com.ceiba.autocine.dominio.modelo.Rol;
import java.util.HashSet;
import java.util.Set;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(int tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public long getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(long idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Set<Rol> getRoles() {
        return new HashSet<>(roles);
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = new HashSet<>(roles);
    }
}
