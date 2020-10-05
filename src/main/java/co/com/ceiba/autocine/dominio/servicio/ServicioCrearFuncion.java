package co.com.ceiba.autocine.dominio.servicio;

import co.com.ceiba.autocine.dominio.modelo.Funcion;
import co.com.ceiba.autocine.dominio.repositorio.RepositorioFuncion;
import org.springframework.stereotype.Service;

@Service
public class ServicioCrearFuncion {

    private final RepositorioFuncion repositorio;

    public ServicioCrearFuncion(RepositorioFuncion repositorio) {
        this.repositorio = repositorio;
    }

    public Funcion ejecutar(Funcion funcion) {
        return this.repositorio.guardar(funcion);
    }

}
