package co.edu.uniquindio.mapper.tools;

import co.edu.uniquindio.dto.Telefono.TelefonoDto;
import co.edu.uniquindio.dto.agenda.AgendaDto;
import co.edu.uniquindio.dto.cita.CitaDto;
import co.edu.uniquindio.dto.especialidad.AgregarEspecialidadDto;
import co.edu.uniquindio.dto.especialidad.EspecialidadDto;
import co.edu.uniquindio.dto.medico.MedicoDto;
import co.edu.uniquindio.dto.user.UserDto;
import co.edu.uniquindio.models.enums.EstadoCita;
import co.edu.uniquindio.models.enums.EstadoUser;
import co.edu.uniquindio.models.objects.Agenda;
import co.edu.uniquindio.models.objects.Cita;
import co.edu.uniquindio.models.tools.Especialidad;
import co.edu.uniquindio.models.tools.Telefono;
import co.edu.uniquindio.models.tools.User;
import co.edu.uniquindio.models.users.Medico;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-15T15:05:29-0500",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.jar, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class EspecialidadMapperImpl implements EspecialidadMapper {

    @Override
    public Especialidad toEntity(AgregarEspecialidadDto agregarEspecialidadDto) {
        if ( agregarEspecialidadDto == null ) {
            return null;
        }

        Especialidad especialidad = new Especialidad();

        especialidad.setEspecialidad( agregarEspecialidadDto.especialidad() );

        especialidad.setMedicos( new java.util.ArrayList<>() );

        return especialidad;
    }

    @Override
    public EspecialidadDto toDto(Especialidad especialidad) {
        if ( especialidad == null ) {
            return null;
        }

        Long id = null;
        String especialidad1 = null;
        List<MedicoDto> medicos = null;

        id = especialidad.getId();
        especialidad1 = especialidad.getEspecialidad();
        medicos = medicoListToMedicoDtoList( especialidad.getMedicos() );

        EspecialidadDto especialidadDto = new EspecialidadDto( id, especialidad1, medicos );

        return especialidadDto;
    }

    protected UserDto userToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        String email = null;
        String password = null;
        EstadoUser estadoUser = null;

        email = user.getEmail();
        password = user.getPassword();
        estadoUser = user.getEstadoUser();

        UserDto userDto = new UserDto( email, password, estadoUser );

        return userDto;
    }

    protected TelefonoDto telefonoToTelefonoDto(Telefono telefono) {
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

    protected List<TelefonoDto> telefonoListToTelefonoDtoList(List<Telefono> list) {
        if ( list == null ) {
            return null;
        }

        List<TelefonoDto> list1 = new ArrayList<TelefonoDto>( list.size() );
        for ( Telefono telefono : list ) {
            list1.add( telefonoToTelefonoDto( telefono ) );
        }

        return list1;
    }

    protected CitaDto citaToCitaDto(Cita cita) {
        if ( cita == null ) {
            return null;
        }

        Long id = null;
        String observaciones = null;
        EstadoCita estadoCita = null;

        id = cita.getId();
        observaciones = cita.getObservaciones();
        estadoCita = cita.getEstadoCita();

        Long idPaciente = null;
        Long idMedico = null;
        Long idFormula = null;
        Long idAgenda = null;

        CitaDto citaDto = new CitaDto( id, observaciones, estadoCita, idPaciente, idMedico, idFormula, idAgenda );

        return citaDto;
    }

    protected List<CitaDto> citaListToCitaDtoList(List<Cita> list) {
        if ( list == null ) {
            return null;
        }

        List<CitaDto> list1 = new ArrayList<CitaDto>( list.size() );
        for ( Cita cita : list ) {
            list1.add( citaToCitaDto( cita ) );
        }

        return list1;
    }

    protected AgendaDto agendaToAgendaDto(Agenda agenda) {
        if ( agenda == null ) {
            return null;
        }

        Long id = null;
        LocalDate dia = null;
        LocalTime horaInicio = null;
        LocalTime horaFin = null;

        id = agenda.getId();
        dia = agenda.getDia();
        horaInicio = agenda.getHoraInicio();
        horaFin = agenda.getHoraFin();

        boolean isActivo = false;
        Long idCita = null;

        AgendaDto agendaDto = new AgendaDto( id, dia, horaInicio, horaFin, isActivo, idCita );

        return agendaDto;
    }

    protected List<AgendaDto> agendaListToAgendaDtoList(List<Agenda> list) {
        if ( list == null ) {
            return null;
        }

        List<AgendaDto> list1 = new ArrayList<AgendaDto>( list.size() );
        for ( Agenda agenda : list ) {
            list1.add( agendaToAgendaDto( agenda ) );
        }

        return list1;
    }

    protected MedicoDto medicoToMedicoDto(Medico medico) {
        if ( medico == null ) {
            return null;
        }

        Long id = null;
        String nombre = null;
        UserDto user = null;
        List<TelefonoDto> telefonos = null;
        List<CitaDto> citas = null;
        List<AgendaDto> agenda = null;

        id = medico.getId();
        nombre = medico.getNombre();
        user = userToUserDto( medico.getUser() );
        telefonos = telefonoListToTelefonoDtoList( medico.getTelefonos() );
        citas = citaListToCitaDtoList( medico.getCitas() );
        agenda = agendaListToAgendaDtoList( medico.getAgenda() );

        Long idEspecialidad = null;

        MedicoDto medicoDto = new MedicoDto( id, nombre, user, telefonos, idEspecialidad, citas, agenda );

        return medicoDto;
    }

    protected List<MedicoDto> medicoListToMedicoDtoList(List<Medico> list) {
        if ( list == null ) {
            return null;
        }

        List<MedicoDto> list1 = new ArrayList<MedicoDto>( list.size() );
        for ( Medico medico : list ) {
            list1.add( medicoToMedicoDto( medico ) );
        }

        return list1;
    }
}
