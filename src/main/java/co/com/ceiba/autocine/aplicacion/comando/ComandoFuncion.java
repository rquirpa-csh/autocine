package co.com.ceiba.autocine.aplicacion.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class ComandoFuncion {

    private long id;
    private String nombre;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private int capacidadTotal;
    private int capacidadDisponible;
    private double costo;

}
