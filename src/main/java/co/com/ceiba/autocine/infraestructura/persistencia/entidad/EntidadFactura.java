package co.com.ceiba.autocine.infraestructura.persistencia.entidad;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "facturas")
public class EntidadFactura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private int numeroEntradas;

    @Column(nullable = false)
    private double subtotal;

    @Column(nullable = false)
    private double porcentajeDescuento;

    @Column(nullable = false)
    private double descuento;

    @Column(nullable = false)
    private double total;

    @Column(nullable = false)
    private LocalDateTime fechaCompra;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_funcion")
    private EntidadFuncion funcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_vehiculo")
    private EntidadVehiculo vehiculo;

}
