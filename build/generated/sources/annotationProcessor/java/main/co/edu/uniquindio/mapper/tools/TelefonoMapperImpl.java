package co.edu.uniquindio.mapper.tools;

import co.edu.uniquindio.dto.Telefono.RegistroTelefonoDto;
import co.edu.uniquindio.dto.Telefono.TelefonoDto;
import co.edu.uniquindio.models.tools.Telefono;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-15T15:05:30-0500",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.jar, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class TelefonoMapperImpl implements TelefonoMapper {

    @Override
    public Telefono toEntity(RegistroTelefonoDto dto) {
        if ( dto == null ) {
            return null;
        }

        Telefono telefono = new Telefono();

        telefono.setNumero( dto.numero() );

        return telefono;
    }

    @Override
    public TelefonoDto toDto(Telefono telefono) {
        if ( telefono == null ) {
            return null;
        }

        Long id = null;
        String numero = null;

        id = telefono.getId();
        numero = telefono.getNumero();

        TelefonoDto telefonoDto = new TelefonoDto( id, numero );

        return telefonoDto;
    }
}
