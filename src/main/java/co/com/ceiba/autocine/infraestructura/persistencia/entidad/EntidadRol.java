package co.com.ceiba.autocine.infraestructura.persistencia.entidad;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "roles")
public class EntidadRol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 30)
    private String nombre;

    @ManyToMany
    @JoinTable(
            name = "usuarios_roles",
            joinColumns = {@JoinColumn(name = "rol_id")},
            inverseJoinColumns = {@JoinColumn(name = "usuario_id")})
    private Set<EntidadUsuario> usuarios;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
