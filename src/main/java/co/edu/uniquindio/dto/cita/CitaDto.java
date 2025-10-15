package co.edu.uniquindio.dto.cita;

import co.edu.uniquindio.dto.agenda.AgendaDto;
import co.edu.uniquindio.dto.formula.FormulaDto;
import co.edu.uniquindio.dto.medico.MedicoDto;
import co.edu.uniquindio.dto.paciente.PacienteDto;
import co.edu.uniquindio.models.enums.EstadoCita;

public record CitaDto(

        Long id,
        String observaciones,
        EstadoCita estadoCita,
        Long idPaciente,
        Long idMedico,
        Long idFormula,
        Long idAgenda

) {
}
