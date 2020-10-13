package co.com.ceiba.autocine.dominio.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Rol {

    public static final int ROL_ADMINISTRADOR = 1;
    public static final int ROL_USUARIO = 2;

    private int id;
    private String nombre;

}
