package co.com.ceiba.autocine.infraestructura.persistencia.entidad;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
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

    @ManyToMany(mappedBy = "usuarios")
    private Set<EntidadRol> roles;

}
