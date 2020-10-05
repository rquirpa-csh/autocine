package co.com.ceiba.autocine.testdatabuilder;

import co.com.ceiba.autocine.aplicacion.comando.ComandoUsuario;
import co.com.ceiba.autocine.dominio.modelo.Rol;
import co.com.ceiba.autocine.dominio.modelo.Usuario;

import java.util.HashSet;
import java.util.Set;

public class UsuarioTestDataBuilder {

    private static final String NOMBRE = "Pedro";
    private static final String APELLIDO = "Perez";
    private static final int TIPO_DOCUMENTO = 1;
    private static final long ID_DOCUMENTO = 4567;
    private static final String CONTRASENA = "4567";

    private long id;
    private String nombre;
    private String apellido;
    private int tipoDocumento;
    private long idDocumento;
    private String contrasena;
    private Set<Rol> roles = new HashSet<>();

    public UsuarioTestDataBuilder() {
        this.nombre = NOMBRE;
        this.apellido = APELLIDO;
        this.tipoDocumento = TIPO_DOCUMENTO;
        this.idDocumento = ID_DOCUMENTO;
        this.contrasena = CONTRASENA;

        Rol rolUsuario = new Rol();
        rolUsuario.setId(Rol.ROL_USUARIO);
        this.roles.add(rolUsuario);
    }

    public UsuarioTestDataBuilder conId(long id) {
        this.id = id;
        return this;
    }

    public UsuarioTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public UsuarioTestDataBuilder conApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public UsuarioTestDataBuilder conTipoDocumento(int tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
        return this;
    }

    public UsuarioTestDataBuilder conIdDocumento(long idDocumento) {
        this.idDocumento = idDocumento;
        return this;
    }

    public UsuarioTestDataBuilder conContrasena(String contrasena) {
        this.contrasena = contrasena;
        return this;
    }

    public UsuarioTestDataBuilder conRoles(Set<Rol> roles) {
        this.roles = roles;
        return this;
    }

    public Usuario build() {
        return new Usuario(
                this.id,
                this.nombre,
                this.apellido,
                this.tipoDocumento,
                this.idDocumento,
                this.contrasena,
                this.roles
        );
    }

    public ComandoUsuario buildComando() {
        return new ComandoUsuario(
                this.id,
                this.nombre,
                this.apellido,
                this.tipoDocumento,
                this.idDocumento,
                this.contrasena,
                this.roles
        );
    }
}
