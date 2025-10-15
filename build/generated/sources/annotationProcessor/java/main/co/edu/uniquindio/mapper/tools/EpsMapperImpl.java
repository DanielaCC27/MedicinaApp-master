package co.edu.uniquindio.mapper.tools;

import co.edu.uniquindio.dto.Telefono.TelefonoDto;
import co.edu.uniquindio.dto.cita.CitaDto;
import co.edu.uniquindio.dto.detalleFormula.DetalleFormulaDto;
import co.edu.uniquindio.dto.eps.EpsDto;
import co.edu.uniquindio.dto.eps.RegistrarEpsDto;
import co.edu.uniquindio.dto.formula.FormulaDto;
import co.edu.uniquindio.dto.paciente.CiudadDto;
import co.edu.uniquindio.dto.paciente.PacienteDto;
import co.edu.uniquindio.dto.user.UserDto;
import co.edu.uniquindio.models.enums.EstadoCita;
import co.edu.uniquindio.models.enums.EstadoUser;
import co.edu.uniquindio.models.objects.Cita;
import co.edu.uniquindio.models.objects.DetalleFormula;
import co.edu.uniquindio.models.objects.Eps;
import co.edu.uniquindio.models.objects.Formula;
import co.edu.uniquindio.models.tools.Ciudad;
import co.edu.uniquindio.models.tools.Telefono;
import co.edu.uniquindio.models.tools.User;
import co.edu.uniquindio.models.users.Paciente;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-15T15:05:30-0500",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.jar, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class EpsMapperImpl implements EpsMapper {

    @Override
    public Eps toEntity(RegistrarEpsDto registrarEpsDto) {
        if ( registrarEpsDto == null ) {
            return null;
        }

        Eps eps = new Eps();

        eps.setNombre( registrarEpsDto.nombre() );

        eps.setPacientes( new java.util.ArrayList<>() );

        return eps;
    }

    @Override
    public EpsDto toDto(Eps eps) {
        if ( eps == null ) {
            return null;
        }

        Long id = null;
        String nombre = null;
        List<PacienteDto> pacientes = null;

        id = eps.getId();
        nombre = eps.getNombre();
        pacientes = pacienteListToPacienteDtoList( eps.getPacientes() );

        EpsDto epsDto = new EpsDto( id, nombre, pacientes );

        return epsDto;
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

    protected CiudadDto ciudadToCiudadDto(Ciudad ciudad) {
        if ( ciudad == null ) {
            return null;
        }

        Long id = null;

        id = ciudad.getId();

        String nombre = null;

        CiudadDto ciudadDto = new CiudadDto( id, nombre );

        return ciudadDto;
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

    protected DetalleFormulaDto detalleFormulaToDetalleFormulaDto(DetalleFormula detalleFormula) {
        if ( detalleFormula == null ) {
            return null;
        }

        Long id = null;
        Integer cantidad = null;
        String observaciones = null;
        String dosis = null;

        id = detalleFormula.getId();
        cantidad = detalleFormula.getCantidad();
        observaciones = detalleFormula.getObservaciones();
        dosis = detalleFormula.getDosis();

        Long idFormula = null;
        Long idMedicamento = null;

        DetalleFormulaDto detalleFormulaDto = new DetalleFormulaDto( id, idFormula, cantidad, observaciones, dosis, idMedicamento );

        return detalleFormulaDto;
    }

    protected List<DetalleFormulaDto> detalleFormulaListToDetalleFormulaDtoList(List<DetalleFormula> list) {
        if ( list == null ) {
            return null;
        }

        List<DetalleFormulaDto> list1 = new ArrayList<DetalleFormulaDto>( list.size() );
        for ( DetalleFormula detalleFormula : list ) {
            list1.add( detalleFormulaToDetalleFormulaDto( detalleFormula ) );
        }

        return list1;
    }

    protected FormulaDto formulaToFormulaDto(Formula formula) {
        if ( formula == null ) {
            return null;
        }

        Long id = null;
        LocalDate fechaRegistro = null;
        List<DetalleFormulaDto> detallesFormula = null;

        id = formula.getId();
        fechaRegistro = formula.getFechaRegistro();
        detallesFormula = detalleFormulaListToDetalleFormulaDtoList( formula.getDetallesFormula() );

        Long idPaciente = null;
        Long idCita = null;

        FormulaDto formulaDto = new FormulaDto( id, fechaRegistro, idPaciente, idCita, detallesFormula );

        return formulaDto;
    }

    protected List<FormulaDto> formulaListToFormulaDtoList(List<Formula> list) {
        if ( list == null ) {
            return null;
        }

        List<FormulaDto> list1 = new ArrayList<FormulaDto>( list.size() );
        for ( Formula formula : list ) {
            list1.add( formulaToFormulaDto( formula ) );
        }

        return list1;
    }

    protected PacienteDto pacienteToPacienteDto(Paciente paciente) {
        if ( paciente == null ) {
            return null;
        }

        Long id = null;
        String nombre = null;
        UserDto user = null;
        CiudadDto ciudad = null;
        List<TelefonoDto> telefonos = null;
        List<CitaDto> citas = null;
        List<FormulaDto> formulasMedicas = null;

        id = paciente.getId();
        nombre = paciente.getNombre();
        user = userToUserDto( paciente.getUser() );
        ciudad = ciudadToCiudadDto( paciente.getCiudad() );
        telefonos = telefonoListToTelefonoDtoList( paciente.getTelefonos() );
        citas = citaListToCitaDtoList( paciente.getCitas() );
        formulasMedicas = formulaListToFormulaDtoList( paciente.getFormulasMedicas() );

        Long idEps = null;

        PacienteDto pacienteDto = new PacienteDto( id, nombre, user, idEps, ciudad, telefonos, citas, formulasMedicas );

        return pacienteDto;
    }

    protected List<PacienteDto> pacienteListToPacienteDtoList(List<Paciente> list) {
        if ( list == null ) {
            return null;
        }

        List<PacienteDto> list1 = new ArrayList<PacienteDto>( list.size() );
        for ( Paciente paciente : list ) {
            list1.add( pacienteToPacienteDto( paciente ) );
        }

        return list1;
    }
}
