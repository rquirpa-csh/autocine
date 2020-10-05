package co.com.ceiba.autocine.infraestructura.persistencia.entidad;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "usuarios")
public class EntidadUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50, nullable = false)
    private String nombre;

    @Column(length = 50, nullable = false)
    private String apellido;

    @Column(nullable = false)
    private long numeroDocumento;

    @Column(nullable = false)
    private String contrasena;

    @OneToOne
    @JoinColumn(name = "id_tipo_documento", referencedColumnName = "id")
    private EntidadTipoDocumento tipoDocumento;

    @OneToMany(mappedBy = "usuario")
    private Set<EntidadVehiculo> vehiculos;

    @ManyToMany(mappedBy = "usuarios")
    private Set<EntidadRol> roles;

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

    public long getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(long numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public EntidadTipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(EntidadTipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Set<EntidadVehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(Set<EntidadVehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public Set<EntidadRol> getRoles() {
        return roles;
    }

    public void setRoles(Set<EntidadRol> roles) {
        this.roles = roles;
    }

}
