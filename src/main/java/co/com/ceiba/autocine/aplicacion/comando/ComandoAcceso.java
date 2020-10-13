package co.com.ceiba.autocine.aplicacion.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoAcceso {

    @NotBlank(message = "El correo es obligatorio")
    @Pattern(regexp = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@[a-z0-9-]+(.[a-z0-9-]+)*(.[a-z]{2,4})$",
            message = "El correo no es valido")
    private String correo;

    @NotBlank(message = "La contraseña obligatorio")
    private String contrasena;

}
