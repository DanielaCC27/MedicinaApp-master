package co.edu.uniquindio.dto.detalleFormula;

import co.edu.uniquindio.dto.formula.FormulaDto;
import co.edu.uniquindio.dto.medicamento.MedicamentoDto;

public record DetalleFormulaDto(


       Long id,
       Long idFormula,
       Integer cantidad,
       String observaciones,
       String dosis,
       Long idMedicamento

) {
}
