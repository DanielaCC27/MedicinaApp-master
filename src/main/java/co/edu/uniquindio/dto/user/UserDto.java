package co.edu.uniquindio.dto.user;

import co.edu.uniquindio.models.enums.EstadoUser;
import jakarta.validation.constraints.Email;

public record UserDto(

        String email,
        String password,
        EstadoUser estadoUser

) {
}
