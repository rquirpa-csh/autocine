package co.com.ceiba.autocine.aplicacion.comando;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComandoVehiculo {

    private long id;
    private long idUsuario;
    private String placa;
    private boolean ecologico;

    public ComandoVehiculo(long id, String placa, long idUsuario, boolean ecologico) {
        this.id = id;
        this.placa = placa;
        this.idUsuario = idUsuario;
        this.ecologico = ecologico;
    }

}
