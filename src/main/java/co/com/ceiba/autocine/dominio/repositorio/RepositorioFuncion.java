package co.com.ceiba.autocine.dominio.repositorio;

import co.com.ceiba.autocine.dominio.modelo.Funcion;

import java.time.LocalDateTime;
import java.util.Set;

public interface RepositorioFuncion {

    Funcion guardar(Funcion funcion);

    Set<Funcion> buscarPorFecha(LocalDateTime fechaInicio, LocalDateTime fechaFin);

    Funcion obtenerPorId(long idFuncion);

    int actualizarDisponible(long idFuncion);
}
