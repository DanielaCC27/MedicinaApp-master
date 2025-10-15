package co.edu.uniquindio.dto.agenda;

import co.edu.uniquindio.dto.cita.CitaDto;
import co.edu.uniquindio.dto.medico.MedicoDto;

import java.time.LocalDate;
import java.time.LocalTime;

public record AgendaDto(

        Long id,
        LocalDate dia,
        LocalTime horaInicio,
        LocalTime horaFin,
        boolean isActivo,
        Long idCita

) {
}
