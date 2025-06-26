package csrent.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.apache.logging.log4j.message.Message;

public class UserDTO {
    @NotBlank(message = "EL campo del nombre no puede quedar en blanco.")
    private String name;

    @NotBlank (message = "EL campo del dirección no puede quedar en blanco.")
    private String address;

    @NotBlank (message = "EL campo del type no puede quedar en blanco.")
    private String type;

    @Email(message = "El correo no es valido, por favor verificar.")
    @NotBlank(message = "EL campo del correo no puede quedar en blanco.")
    private String email;

    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*()]).{8,}$",
            message = "Expresión regular (lo que necesitamos que tenga), debería de llevar mayúsculas,minúsculas,etc.")
    @NotBlank (message = "EL campo de la contaseña no puede quedar en blanco.")
    private String password;

    public UserDTO() {

    }

    public UserDTO(String name, String address, String type, String email, String password) {
        this.name = name;
        this.address = address;
        this.type = type;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
