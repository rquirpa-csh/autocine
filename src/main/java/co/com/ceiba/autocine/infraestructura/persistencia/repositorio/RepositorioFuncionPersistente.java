package co.com.ceiba.autocine.infraestructura.persistencia.repositorio;

import co.com.ceiba.autocine.dominio.modelo.Funcion;
import co.com.ceiba.autocine.dominio.repositorio.RepositorioFuncion;
import co.com.ceiba.autocine.infraestructura.persistencia.entidad.EntidadFuncion;
import co.com.ceiba.autocine.infraestructura.persistencia.mapeador.MapeadorFuncion;
import co.com.ceiba.autocine.infraestructura.persistencia.repositorio.jpa.RepositorioFuncionJPA;
import org.springframework.stereotype.Repository;

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

}
