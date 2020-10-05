package co.com.ceiba.autocine.dominio.modelo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Funcion {

    private long id;
    private String nombre;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private int capacidadTotal;
    private int capacidadDisponible;
    private double costo;

    public Funcion(long id, String nombre, LocalDateTime fechaInicio, LocalDateTime fechaFin, int capacidadTotal, int capacidadDisponible, double costo) {
        this.id = id;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.capacidadTotal = capacidadTotal;
        this.capacidadDisponible = capacidadDisponible;
        this.costo = costo;
    }
}
