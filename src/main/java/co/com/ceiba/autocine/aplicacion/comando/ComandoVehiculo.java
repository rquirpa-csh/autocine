package co.com.ceiba.autocine.aplicacion.comando;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComandoVehiculo {

    private long id;
    private String placa;
    private long idUsuario;

    public ComandoVehiculo(long id, String placa, long idUsuario) {
        this.id = id;
        this.placa = placa;
        this.idUsuario = idUsuario;
    }

}
