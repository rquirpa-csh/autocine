package co.com.ceiba.autocine.dominio.modelo;

public class Rol {

    public static final int ROL_ADMINISTRADOR = 1;
    public static final int ROL_USUARIO = 2;

    private int id;
    private String nombre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
