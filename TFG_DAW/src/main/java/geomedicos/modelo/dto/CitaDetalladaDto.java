package geomedicos.modelo.dto;

import java.time.LocalDate;
import geomedicos.modelo.entities.Cita;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CitaDetalladaDto {

    private int idCita;
    private LocalDate fecha;
    private String horaInicio;
    private String nombreMedico;
    private String nombrePaciente;
    private String especialidad;
    private String nombreClinica;

    public static CitaDetalladaDto fromEntity(Cita cita) {

        return CitaDetalladaDto.builder()
            .idCita(cita.getIdCita())
            .fecha(cita.getFecha())
            .horaInicio(cita.getHorariosMedico().getHoraInicio().toString())
            .nombreMedico(
                cita.getHorariosMedico().getMedico().getUsuario().getNombre() + " " +
                cita.getHorariosMedico().getMedico().getUsuario().getApellidos())
            .nombrePaciente(
                cita.getPaciente().getNombre() + " " +
                cita.getPaciente().getApellidos())
            .especialidad(
                cita.getHorariosMedico().getMedico().getEspecialidad().getNombre())
            .nombreClinica(
                cita.getHorariosMedico().getClinica().getNombre())
            .build();
    }
}

