package co.com.ceiba.autocine.dominio.modelo;

import co.com.ceiba.autocine.dominio.exception.ApplicationException;
import co.com.ceiba.autocine.utils.StringUtils;
import lombok.Getter;

@Getter
public class Vehiculo {

    public static final String ERROR_ID = "El id del vehiculo deber ser positivo";
    public static final String ERROR_PLACA = "La placa es obligatoria";
    public static final String ERROR_ID_USUARIO = "El id de usuario deber ser positivo";

    private long id;
    private String placa;
    private long idUsuario;

    public Vehiculo(long id, String placa, long idUsuario) {
        setId(id);
        setPlaca(placa);
        setIdUsuario(idUsuario);
    }

    public void setId(long id) {
        if (id < 0) {
            throw new ApplicationException(ERROR_ID);
        }
        this.id = id;
    }

    public void setPlaca(String placa) {
        if (StringUtils.isNullOrEmpty(placa)) {
            throw new ApplicationException(ERROR_PLACA);
        }
        this.placa = placa;
    }

    public void setIdUsuario(long idUsuario) {
        if (idUsuario <= 0) {
            throw new ApplicationException(ERROR_ID_USUARIO);
        }
        this.idUsuario = idUsuario;
    }

}
