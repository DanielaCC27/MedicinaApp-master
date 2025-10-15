package co.edu.uniquindio.mapper.users;

import co.edu.uniquindio.dto.Telefono.RegistroTelefonoDto;
import co.edu.uniquindio.dto.Telefono.TelefonoDto;
import co.edu.uniquindio.dto.agenda.AgendaDto;
import co.edu.uniquindio.dto.cita.CitaDto;
import co.edu.uniquindio.dto.medico.EditarMedicoDto;
import co.edu.uniquindio.dto.medico.MedicoDto;
import co.edu.uniquindio.dto.medico.RegistrarMedicoDto;
import co.edu.uniquindio.dto.user.CrearUserDto;
import co.edu.uniquindio.dto.user.UserDto;
import co.edu.uniquindio.mapper.tools.TelefonoMapper;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-15T15:05:30-0500",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.jar, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class MedicoMapperImpl implements MedicoMapper {

    @Autowired
    private TelefonoMapper telefonoMapper;

    @Override
    public Medico toDto(RegistrarMedicoDto registrarMedicoDto) {
        if ( registrarMedicoDto == null ) {
            return null;
        }

        Medico medico = new Medico();

        medico.setNombre( registrarMedicoDto.nombre() );
        medico.setUser( crearUserDtoToUser( registrarMedicoDto.user() ) );
        medico.setTelefonos( registroTelefonoDtoListToTelefonoList( registrarMedicoDto.telefonos() ) );

        medico.setCitas( new java.util.ArrayList<>() );
        medico.setAgenda( new java.util.ArrayList<>() );

        return medico;
    }

    @Override
    public MedicoDto toDto(Medico medico) {
        if ( medico == null ) {
            return null;
        }

        Long idEspecialidad = null;
        Long id = null;
        String nombre = null;
        UserDto user = null;
        List<TelefonoDto> telefonos = null;
        List<CitaDto> citas = null;
        List<AgendaDto> agenda = null;

        idEspecialidad = medicoEspecialidadId( medico );
        id = medico.getId();
        nombre = medico.getNombre();
        user = userToUserDto( medico.getUser() );
        telefonos = telefonoListToTelefonoDtoList( medico.getTelefonos() );
        citas = citaListToCitaDtoList( medico.getCitas() );
        agenda = agendaListToAgendaDtoList( medico.getAgenda() );

        MedicoDto medicoDto = new MedicoDto( id, nombre, user, telefonos, idEspecialidad, citas, agenda );

        return medicoDto;
    }

    @Override
    public void updateEntity(EditarMedicoDto editarMedicoDto, Medico medico) {
        if ( editarMedicoDto == null ) {
            return;
        }

        medico.setNombre( editarMedicoDto.nombre() );
    }

    protected User crearUserDtoToUser(CrearUserDto crearUserDto) {
        if ( crearUserDto == null ) {
            return null;
        }

        User user = new User();

        user.setEmail( crearUserDto.email() );
        user.setPassword( crearUserDto.password() );

        user.setEstadoUser( EstadoUser.ACTIVO );

        return user;
    }

    protected List<Telefono> registroTelefonoDtoListToTelefonoList(List<RegistroTelefonoDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Telefono> list1 = new ArrayList<Telefono>( list.size() );
        for ( RegistroTelefonoDto registroTelefonoDto : list ) {
            list1.add( telefonoMapper.toEntity( registroTelefonoDto ) );
        }

        return list1;
    }

    private Long medicoEspecialidadId(Medico medico) {
        Especialidad especialidad = medico.getEspecialidad();
        if ( especialidad == null ) {
            return null;
        }
        return especialidad.getId();
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

    protected List<TelefonoDto> telefonoListToTelefonoDtoList(List<Telefono> list) {
        if ( list == null ) {
            return null;
        }

        List<TelefonoDto> list1 = new ArrayList<TelefonoDto>( list.size() );
        for ( Telefono telefono : list ) {
            list1.add( telefonoMapper.toDto( telefono ) );
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
}
