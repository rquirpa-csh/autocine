package co.com.ceiba.autocine.infraestructura.persistencia.entidad;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "vehiculos")
public class EntidadVehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 6, nullable = false, unique = true)
    private String placa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private EntidadUsuario usuario;

    @OneToMany(mappedBy = "vehiculo")
    private Set<EntidadFactura> facturas;

}
