package co.edu.uniquindio.mapper.objects;

import co.edu.uniquindio.dto.medicamento.MedicamentoDto;
import co.edu.uniquindio.dto.medicamento.RegistrarMedicamentoDto;
import co.edu.uniquindio.models.objects.Medicamento;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-15T15:05:29-0500",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.jar, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class MedicamentoMapperImpl implements MedicamentoMapper {

    @Override
    public Medicamento toEntity(RegistrarMedicamentoDto registrarMedicamentoDto) {
        if ( registrarMedicamentoDto == null ) {
            return null;
        }

        Medicamento medicamento = new Medicamento();

        medicamento.setNombre( registrarMedicamentoDto.nombre() );
        medicamento.setPrecio( registrarMedicamentoDto.precio() );

        return medicamento;
    }

    @Override
    public MedicamentoDto toDto(Medicamento medicamento) {
        if ( medicamento == null ) {
            return null;
        }

        Long id = null;
        String nombre = null;
        Double precio = null;

        id = medicamento.getId();
        nombre = medicamento.getNombre();
        precio = medicamento.getPrecio();

        MedicamentoDto medicamentoDto = new MedicamentoDto( id, nombre, precio );

        return medicamentoDto;
    }
}
