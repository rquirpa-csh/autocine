package co.com.ceiba.autocine.testdatabuilder;

import co.com.ceiba.autocine.aplicacion.comando.ComandoFuncion;
import co.com.ceiba.autocine.dominio.modelo.Funcion;

import java.time.LocalDateTime;

public class FuncionTestDataBuilder {

    private static final String NOMBRE = "matrix";
    private static final LocalDateTime FECHA_INICIO = LocalDateTime.parse("2020-10-05T14:00:00");
    private static final int DURACION = 120;
    private static final int CAPACIDAD_TOTAL = 30;
    private static final int CAPACIDAD_DISPONIBLE = 30;
    private static final Double COSTO = 10000d;

    private long id;
    private String nombre;
    private LocalDateTime fecha;
    private int duracion;
    private int capacidadTotal;
    private int capacidadDisponible;
    private double costo;

    public FuncionTestDataBuilder() {
        this.nombre = NOMBRE;
        this.fecha = FECHA_INICIO;
        this.duracion = DURACION;
        this.capacidadTotal = CAPACIDAD_TOTAL;
        this.capacidadDisponible = CAPACIDAD_DISPONIBLE;
        this.costo = COSTO;
    }

    public FuncionTestDataBuilder conId(long id) {
        this.id = id;
        return this;
    }

    public FuncionTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public FuncionTestDataBuilder conFecha(LocalDateTime fecha) {
        this.fecha = fecha;
        return this;
    }

    public FuncionTestDataBuilder conDuracion(int duracion) {
        this.duracion = duracion;
        return this;
    }

    public FuncionTestDataBuilder conCapacidadTotal(int capacidadTotal) {
        this.capacidadTotal = capacidadTotal;
        return this;
    }

    public FuncionTestDataBuilder conCapacidadDisponible(int capacidadDisponible) {
        this.capacidadDisponible = capacidadDisponible;
        return this;
    }

    public FuncionTestDataBuilder conCosto(double costo) {
        this.costo = costo;
        return this;
    }

    public Funcion build() {
        return new Funcion(
                this.id,
                this.nombre,
                this.fecha,
                this.fecha.plusMinutes(this.duracion),
                this.capacidadTotal,
                this.capacidadDisponible,
                this.costo
        );
    }

    public ComandoFuncion buildComando() {
        return new ComandoFuncion(
                this.id,
                this.nombre,
                this.fecha,
                this.duracion,
                this.capacidadTotal,
                this.capacidadDisponible,
                this.costo
        );
    }

}
