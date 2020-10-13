package co.com.ceiba.autocine.infraestructura.persistencia.repositorio;

import co.com.ceiba.autocine.dominio.modelo.Funcion;
import co.com.ceiba.autocine.dominio.repositorio.RepositorioFuncion;
import co.com.ceiba.autocine.infraestructura.persistencia.entidad.EntidadFuncion;
import co.com.ceiba.autocine.infraestructura.persistencia.mapeador.MapeadorFuncion;
import co.com.ceiba.autocine.infraestructura.persistencia.repositorio.jpa.RepositorioFuncionJPA;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;

@Repository
public class RepositorioFuncionPersistente implements RepositorioFuncion {

    private RepositorioFuncionJPA repositorio;

    public RepositorioFuncionPersistente(RepositorioFuncionJPA repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public Funcion guardar(Funcion funcion) {
        EntidadFuncion entidad = repositorio.save(MapeadorFuncion.toEntity(funcion));
        return MapeadorFuncion.toDomain(entidad);
    }

    @Override
    public Set<Funcion> buscarPorFecha(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        Set<EntidadFuncion> entitySet = repositorio.buscarPorFecha(fechaInicio, fechaFin);
        return MapeadorFuncion.toDomainSet(entitySet);
    }

    @Override
    public Funcion obtenerPorId(long idFuncion) {
        Funcion funcion = null;
        Optional<EntidadFuncion> entidad = repositorio.findById(idFuncion);
        if (entidad.isPresent()) {
            funcion = MapeadorFuncion.toDomain(entidad.get());
        }
        return funcion;
    }

    @Override
    public int actualizarDisponible(long idFuncion) {
        return repositorio.actualizarDisponible(idFuncion);
    }
}
