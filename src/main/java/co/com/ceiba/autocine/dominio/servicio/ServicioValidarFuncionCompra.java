package co.com.ceiba.autocine.dominio.servicio;

import co.com.ceiba.autocine.dominio.exception.ApplicationException;
import co.com.ceiba.autocine.dominio.modelo.Funcion;
import co.com.ceiba.autocine.dominio.repositorio.RepositorioFuncion;
import org.springframework.stereotype.Service;

@Service
public class ServicioValidarFuncionCompra {

    public static final String FUNCION_NO_EXISTE = "Funcion no existe";
    public static final String CUPOS_AGOTADOS = "No hay cupos disponibles";

    private final RepositorioFuncion repositorioFuncion;

    public ServicioValidarFuncionCompra(RepositorioFuncion repositorioFuncion) {
        this.repositorioFuncion = repositorioFuncion;
    }

    public Funcion ejecutar(long idFuncion) {
        Funcion funcion = repositorioFuncion.obtenerPorId(idFuncion);
        if (funcion == null) {
            throw new ApplicationException(FUNCION_NO_EXISTE);
        }

        if (funcion.getCapacidadDisponible() <= 0) {
            throw new ApplicationException(CUPOS_AGOTADOS);
        }
        return funcion;
    }

}
