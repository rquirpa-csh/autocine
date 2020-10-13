package co.com.ceiba.autocine.testdatabuilder;

import co.com.ceiba.autocine.aplicacion.comando.ComandoVehiculo;
import co.com.ceiba.autocine.dominio.modelo.Vehiculo;

public class VehiculoTestDataBuilder {

    private static final String PLACA = "XYZ-123";
    private static final long ID_USUARIO = 1;

    private long id;
    private String placa;
    private long idUsuario;
    private boolean ecologico;

    public VehiculoTestDataBuilder() {
        this.placa = PLACA;
        this.idUsuario = ID_USUARIO;
    }

    public VehiculoTestDataBuilder conId(long id) {
        this.id = id;
        return this;
    }

    public VehiculoTestDataBuilder conPlaca(String placa) {
        this.placa = placa;
        return this;
    }

    public VehiculoTestDataBuilder conIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }

    public VehiculoTestDataBuilder conEcologico(boolean ecologico) {
        this.ecologico = ecologico;
        return this;
    }

    public Vehiculo build() {
        return new Vehiculo(
                this.id,
                this.placa,
                this.idUsuario,
                this.ecologico
        );
    }

    public ComandoVehiculo buildComando() {
        return new ComandoVehiculo(
                this.id,
                this.placa,
                this.idUsuario,
                this.ecologico
        );
    }

}
