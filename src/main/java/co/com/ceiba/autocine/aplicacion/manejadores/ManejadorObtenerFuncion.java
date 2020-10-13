package co.com.ceiba.autocine.aplicacion.manejadores;

import co.com.ceiba.autocine.dominio.modelo.Funcion;
import co.com.ceiba.autocine.dominio.repositorio.RepositorioFuncion;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Set;

@Component
public class ManejadorObtenerFuncion {

    private final RepositorioFuncion repositorio;

    public ManejadorObtenerFuncion(RepositorioFuncion repositorio) {
        this.repositorio = repositorio;
    }

    public Set<Funcion> buscarPorFecha(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        return repositorio.buscarPorFecha(fechaInicio, fechaFin);
    }

}
