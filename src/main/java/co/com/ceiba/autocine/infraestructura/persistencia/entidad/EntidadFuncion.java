package co.com.ceiba.autocine.infraestructura.persistencia.entidad;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Set;

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

    @OneToMany(mappedBy = "funcion")
    private Set<EntidadFactura> facturas;

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

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getCapacidadTotal() {
        return capacidadTotal;
    }

    public void setCapacidadTotal(int capacidadTotal) {
        this.capacidadTotal = capacidadTotal;
    }

    public int getCapacidadDisponible() {
        return capacidadDisponible;
    }

    public void setCapacidadDisponible(int capacidadDisponible) {
        this.capacidadDisponible = capacidadDisponible;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

}
