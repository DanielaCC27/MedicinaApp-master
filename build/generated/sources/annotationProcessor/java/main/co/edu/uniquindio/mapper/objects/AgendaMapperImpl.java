package co.edu.uniquindio.mapper.objects;

import co.edu.uniquindio.dto.agenda.AgendaDto;
import co.edu.uniquindio.models.objects.Agenda;
import co.edu.uniquindio.models.objects.Cita;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-15T15:05:30-0500",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.jar, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class AgendaMapperImpl implements AgendaMapper {

    @Override
    public AgendaDto toDto(Agenda agenda) {
        if ( agenda == null ) {
            return null;
        }

        Long idCita = null;
        boolean isActivo = false;
        Long id = null;
        LocalDate dia = null;
        LocalTime horaInicio = null;
        LocalTime horaFin = null;

        idCita = agendaCitaId( agenda );
        isActivo = agenda.isActivo();
        id = agenda.getId();
        dia = agenda.getDia();
        horaInicio = agenda.getHoraInicio();
        horaFin = agenda.getHoraFin();

        AgendaDto agendaDto = new AgendaDto( id, dia, horaInicio, horaFin, isActivo, idCita );

        return agendaDto;
    }

    private Long agendaCitaId(Agenda agenda) {
        Cita cita = agenda.getCita();
        if ( cita == null ) {
            return null;
        }
        return cita.getId();
    }
}
