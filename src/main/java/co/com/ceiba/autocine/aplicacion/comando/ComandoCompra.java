package co.com.ceiba.autocine.aplicacion.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ComandoCompra {

    @Min(value = 1, message = "El id de la funcion debe ser positivo")
    private long idFuncion;

    @Pattern(regexp = "^[a-zA-Z]{3}-[0-9]{3}$", message = "La placa deben tener este formato ZZZ-999")
    private String placa;

    @Min(value = 1, message = "El minimo de tickets es 1")
    @Max(value = 4, message = "El maximo de tickets es 4")
    private int cantidadTickets;

}
