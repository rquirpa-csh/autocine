package co.com.ceiba.autocine.dominio.modelo;

import co.com.ceiba.autocine.dominio.exception.ApplicationException;
import lombok.Getter;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;

@Getter
public class Funcion {

    public static final String ERROR_ID = "El id de la función debe ser positivo";
    public static final String ERROR_NOMBRE = "La función debe tener un nombre";
    public static final String ERROR_FECHA_INICIO = "La función debe tener una de inicio";
    public static final String ERROR_FECHA_FIN = "La función debe tener una fecha fin";
    public static final String ERROR_FECHA_FIN_INFERIOR = "La fecha fin debe ser superior a la fecha inicio";
    public static final String ERROR_CAPACIDAD_TOTAL = "La capacidad total debe positivo";
    public static final String ERROR_CAPACIDAD_DISPONIBLE = "La capacidad disponible debe positivo";
    public static final String ERROR_CAPACIDAD_DISPONIBLE_MAYOR_A_TOTAL = "La capacidad disponible debe ser menor o igual a la capacidad total";
    public static final String ERROR_COSTO = "El costo debe ser positivo";

    private long id;
    private String nombre;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private int capacidadTotal;
    private int capacidadDisponible;
    private double costo;

    public Funcion(long id) {
        setId(id);
    }

    public Funcion(long id, String nombre, LocalDateTime fechaInicio, LocalDateTime fechaFin, int capacidadTotal, int capacidadDisponible, double costo) {
        setId(id);
        setNombre(nombre);
        setFechaInicio(fechaInicio);
        setFechaFin(fechaFin);
        setCapacidadTotal(capacidadTotal);
        setCapacidadDisponible(capacidadDisponible);
        setCosto(costo);
    }

    public void setId(long id) {
        if (id < 0) {
            throw new ApplicationException(Funcion.ERROR_ID);
        }
        this.id = id;
    }

    public void setNombre(String nombre) {
        if (StringUtils.isEmpty(nombre)) {
            throw new ApplicationException(Funcion.ERROR_NOMBRE);
        }
        this.nombre = nombre;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        if (fechaInicio == null) {
            throw new ApplicationException(Funcion.ERROR_FECHA_INICIO);
        }
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        if (fechaFin == null) {
            throw new ApplicationException(Funcion.ERROR_FECHA_FIN);
        }
        if (fechaFin.isBefore(this.fechaInicio)) {
            throw new ApplicationException(Funcion.ERROR_FECHA_FIN_INFERIOR);
        }
        this.fechaFin = fechaFin;
    }

    public void setCapacidadTotal(int capacidadTotal) {
        if (capacidadTotal <= 0) {
            throw new ApplicationException(Funcion.ERROR_CAPACIDAD_TOTAL);
        }
        this.capacidadTotal = capacidadTotal;
    }

    public void setCapacidadDisponible(int capacidadDisponible) {
        if (capacidadDisponible < 0) {
            throw new ApplicationException(Funcion.ERROR_CAPACIDAD_DISPONIBLE);
        }
        if (capacidadDisponible > this.capacidadTotal) {
            throw new ApplicationException(Funcion.ERROR_CAPACIDAD_DISPONIBLE_MAYOR_A_TOTAL);
        }
        this.capacidadDisponible = capacidadDisponible;
    }

    public void setCosto(double costo) {
        if (costo <= 0) {
            throw new ApplicationException(Funcion.ERROR_COSTO);
        }
        this.costo = costo;
    }

}
