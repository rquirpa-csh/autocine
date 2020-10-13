package co.com.ceiba.autocine.aplicacion.comando;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
public class ComandoFuncion {

    private long id;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotNull(message = "la fecha es obligatoria")
    private LocalDateTime fecha;

    @Min(value = 1, message = "La duracion debe ser positiva")
    private int duracion;

    @Min(value = 1, message = "La capacidad total positiva")
    private int capacidadTotal;

    @Min(value = 1, message = "La capacidad disponible positiva")
    private int capacidadDisponible;

    @Min(value = 1, message = "El costo debe ser positivo")
    private double costo;

    public ComandoFuncion(long id, String nombre, LocalDateTime fecha, int duracion, int capacidadTotal, int capacidadDisponible, double costo) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.duracion = duracion;
        this.capacidadTotal = capacidadTotal;
        this.capacidadDisponible = capacidadDisponible;
        this.costo = costo;
    }

}
