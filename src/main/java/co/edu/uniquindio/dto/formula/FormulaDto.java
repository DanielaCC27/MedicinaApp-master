package co.edu.uniquindio.dto.formula;

import co.edu.uniquindio.dto.cita.CitaDto;
import co.edu.uniquindio.dto.detalleFormula.DetalleFormulaDto;
import co.edu.uniquindio.dto.paciente.PacienteDto;

import java.time.LocalDate;
import java.util.List;

public record FormulaDto (


    Long id,
    LocalDate fechaRegistro,
    Long idPaciente,
    Long idCita,
    List<DetalleFormulaDto> detallesFormula

){
}
