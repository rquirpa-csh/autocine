package co.com.ceiba.autocine.infraestructura.persistencia.entidad;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "vehiculos")
public class EntidadVehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 7, nullable = false, unique = true)
    private String placa;

    @Column(nullable = false)
    private boolean ecologico;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private EntidadUsuario usuario;

}
