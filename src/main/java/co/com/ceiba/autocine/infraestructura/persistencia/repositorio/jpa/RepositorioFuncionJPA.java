package co.com.ceiba.autocine.infraestructura.persistencia.repositorio.jpa;

import co.com.ceiba.autocine.infraestructura.persistencia.entidad.EntidadFuncion;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Set;

@Repository
public interface RepositorioFuncionJPA extends CrudRepository<EntidadFuncion, Long> {

    @Query("from funciones x where x.fechaInicio >= ?1 and x.fechaInicio <= ?2")
    Set<EntidadFuncion> buscarPorFecha(LocalDateTime fechaInicio, LocalDateTime fechaFin);

    @Modifying
    @Query("update funciones set capacidadDisponible = capacidadDisponible - 1 where id = ?1 and capacidadDisponible > 0")
    int actualizarDisponible(long idFuncion);

}
