package co.edu.uniquindio.mapper.tools;

import co.edu.uniquindio.dto.detalleFormula.DetalleFormulaDto;
import co.edu.uniquindio.dto.detalleFormula.RegistroDetalleFormulaDto;
import co.edu.uniquindio.models.objects.DetalleFormula;
import co.edu.uniquindio.models.objects.Formula;
import co.edu.uniquindio.models.objects.Medicamento;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-15T15:05:30-0500",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.jar, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class DetalleFormulaMapperImpl implements DetalleFormulaMapper {

    @Override
    public DetalleFormula toEntity(RegistroDetalleFormulaDto registroDetalleFormulaDto) {
        if ( registroDetalleFormulaDto == null ) {
            return null;
        }

        DetalleFormula detalleFormula = new DetalleFormula();

        detalleFormula.setCantidad( registroDetalleFormulaDto.cantidad() );
        detalleFormula.setObservaciones( registroDetalleFormulaDto.observaciones() );
        detalleFormula.setDosis( registroDetalleFormulaDto.dosis() );

        return detalleFormula;
    }

    @Override
    public DetalleFormulaDto toDto(DetalleFormula detalleFormula) {
        if ( detalleFormula == null ) {
            return null;
        }

        Long idFormula = null;
        Long idMedicamento = null;
        Long id = null;
        Integer cantidad = null;
        String observaciones = null;
        String dosis = null;

        idFormula = detalleFormulaFormulaId( detalleFormula );
        idMedicamento = detalleFormulaMedicamentoId( detalleFormula );
        id = detalleFormula.getId();
        cantidad = detalleFormula.getCantidad();
        observaciones = detalleFormula.getObservaciones();
        dosis = detalleFormula.getDosis();

        DetalleFormulaDto detalleFormulaDto = new DetalleFormulaDto( id, idFormula, cantidad, observaciones, dosis, idMedicamento );

        return detalleFormulaDto;
    }

    private Long detalleFormulaFormulaId(DetalleFormula detalleFormula) {
        Formula formula = detalleFormula.getFormula();
        if ( formula == null ) {
            return null;
        }
        return formula.getId();
    }

    private Long detalleFormulaMedicamentoId(DetalleFormula detalleFormula) {
        Medicamento medicamento = detalleFormula.getMedicamento();
        if ( medicamento == null ) {
            return null;
        }
        return medicamento.getId();
    }
}
