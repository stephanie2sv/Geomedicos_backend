package geomedicos.modelo.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.modelmapper.ModelMapper;

import geomedicos.modelo.entities.HorariosMedico;
import geomedicos.modelo.entities.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@EqualsAndHashCode(of = "idHorario")

public class HorarioMedicoDto {
	
	private int idHorario;
	
	private String colegiado;

	private LocalDate fechaCita;

	private LocalTime horaInicio;

	private int idClinica;
	
	public static HorarioMedicoDto convertToHorarioMedicoDto(HorariosMedico horario) {
		
		ModelMapper model = new ModelMapper();
		HorarioMedicoDto horarioDto =  model.map(horario, HorarioMedicoDto.class);
		horarioDto.setColegiado(horario.getMedico().getColegiado());
		return horarioDto;
		
		
	}
	
	
	
	public static List<HorarioMedicoDto> convertList(List<HorariosMedico> horarios) {
		
		return horarios.stream()
				.map(ele -> HorarioMedicoDto.convertToHorarioMedicoDto(ele))
				.toList();
		
	}

}
