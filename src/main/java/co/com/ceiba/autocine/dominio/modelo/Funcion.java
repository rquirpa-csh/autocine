package co.com.ceiba.autocine.dominio.modelo;

import java.time.LocalDateTime;

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
