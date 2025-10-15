package co.edu.uniquindio.mapper.objects;

import co.edu.uniquindio.dto.detalleFormula.DetalleFormulaDto;
import co.edu.uniquindio.dto.detalleFormula.RegistroDetalleFormulaDto;
import co.edu.uniquindio.dto.formula.FormulaDto;
import co.edu.uniquindio.dto.formula.RegistroFormulaDto;
import co.edu.uniquindio.mapper.tools.DetalleFormulaMapper;
import co.edu.uniquindio.models.objects.Cita;
import co.edu.uniquindio.models.objects.DetalleFormula;
import co.edu.uniquindio.models.objects.Formula;
import co.edu.uniquindio.models.users.Paciente;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-15T15:05:29-0500",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.jar, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class FormulaMapperImpl implements FormulaMapper {

    @Autowired
    private DetalleFormulaMapper detalleFormulaMapper;

    @Override
    public Formula toEntity(RegistroFormulaDto registroFormulaDto) {
        if ( registroFormulaDto == null ) {
            return null;
        }

        Formula formula = new Formula();

        formula.setDetallesFormula( registroDetalleFormulaDtoListToDetalleFormulaList( registroFormulaDto.detallesFormula() ) );

        formula.setFechaRegistro( java.time.LocalDate.now() );

        return formula;
    }

    @Override
    public FormulaDto toDto(Formula formula) {
        if ( formula == null ) {
            return null;
        }

        Long idPaciente = null;
        Long idCita = null;
        Long id = null;
        LocalDate fechaRegistro = null;
        List<DetalleFormulaDto> detallesFormula = null;

        idPaciente = formulaPacienteId( formula );
        idCita = formulaCitaId( formula );
        id = formula.getId();
        fechaRegistro = formula.getFechaRegistro();
        detallesFormula = detalleFormulaListToDetalleFormulaDtoList( formula.getDetallesFormula() );

        FormulaDto formulaDto = new FormulaDto( id, fechaRegistro, idPaciente, idCita, detallesFormula );

        return formulaDto;
    }

    protected List<DetalleFormula> registroDetalleFormulaDtoListToDetalleFormulaList(List<RegistroDetalleFormulaDto> list) {
        if ( list == null ) {
            return null;
        }

        List<DetalleFormula> list1 = new ArrayList<DetalleFormula>( list.size() );
        for ( RegistroDetalleFormulaDto registroDetalleFormulaDto : list ) {
            list1.add( detalleFormulaMapper.toEntity( registroDetalleFormulaDto ) );
        }

        return list1;
    }

    private Long formulaPacienteId(Formula formula) {
        Paciente paciente = formula.getPaciente();
        if ( paciente == null ) {
            return null;
        }
        return paciente.getId();
    }

    private Long formulaCitaId(Formula formula) {
        Cita cita = formula.getCita();
        if ( cita == null ) {
            return null;
        }
        return cita.getId();
    }

    protected List<DetalleFormulaDto> detalleFormulaListToDetalleFormulaDtoList(List<DetalleFormula> list) {
        if ( list == null ) {
            return null;
        }

        List<DetalleFormulaDto> list1 = new ArrayList<DetalleFormulaDto>( list.size() );
        for ( DetalleFormula detalleFormula : list ) {
            list1.add( detalleFormulaMapper.toDto( detalleFormula ) );
        }

        return list1;
    }
}
