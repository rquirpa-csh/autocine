package co.com.ceiba.autocine.infraestructura.persistencia.entidad;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "funciones")
public class EntidadFuncion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private LocalDateTime fechaInicio;

    @Column(nullable = false)
    private LocalDateTime fechaFin;

    @Column(nullable = false)
    private int capacidadTotal;

    @Column(nullable = false)
    private int capacidadDisponible;

    @Column(nullable = false)
    private double costo;

}
