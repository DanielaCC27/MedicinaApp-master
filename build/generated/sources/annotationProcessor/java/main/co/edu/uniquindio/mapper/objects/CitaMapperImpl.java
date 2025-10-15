package co.edu.uniquindio.mapper.objects;

import co.edu.uniquindio.dto.cita.CitaDto;
import co.edu.uniquindio.dto.cita.RegistrarCitaDto;
import co.edu.uniquindio.models.enums.EstadoCita;
import co.edu.uniquindio.models.objects.Agenda;
import co.edu.uniquindio.models.objects.Cita;
import co.edu.uniquindio.models.objects.Formula;
import co.edu.uniquindio.models.users.Medico;
import co.edu.uniquindio.models.users.Paciente;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-15T15:05:30-0500",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.jar, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class CitaMapperImpl implements CitaMapper {

    @Override
    public Cita toEntity(RegistrarCitaDto registrarCitaDto) {
        if ( registrarCitaDto == null ) {
            return null;
        }

        Cita cita = new Cita();

        cita.setObservaciones( registrarCitaDto.observaciones() );

        cita.setEstadoCita( EstadoCita.AGENDADA );

        return cita;
    }

    @Override
    public CitaDto toDto(Cita cita) {
        if ( cita == null ) {
            return null;
        }

        Long idPaciente = null;
        Long idMedico = null;
        Long idFormula = null;
        Long idAgenda = null;
        Long id = null;
        String observaciones = null;
        EstadoCita estadoCita = null;

        idPaciente = citaPacienteId( cita );
        idMedico = citaMedicoId( cita );
        idFormula = citaFormulaId( cita );
        idAgenda = citaAgendaId( cita );
        id = cita.getId();
        observaciones = cita.getObservaciones();
        estadoCita = cita.getEstadoCita();

        CitaDto citaDto = new CitaDto( id, observaciones, estadoCita, idPaciente, idMedico, idFormula, idAgenda );

        return citaDto;
    }

    private Long citaPacienteId(Cita cita) {
        Paciente paciente = cita.getPaciente();
        if ( paciente == null ) {
            return null;
        }
        return paciente.getId();
    }

    private Long citaMedicoId(Cita cita) {
        Medico medico = cita.getMedico();
        if ( medico == null ) {
            return null;
        }
        return medico.getId();
    }

    private Long citaFormulaId(Cita cita) {
        Formula formula = cita.getFormula();
        if ( formula == null ) {
            return null;
        }
        return formula.getId();
    }

    private Long citaAgendaId(Cita cita) {
        Agenda agenda = cita.getAgenda();
        if ( agenda == null ) {
            return null;
        }
        return agenda.getId();
    }
}
