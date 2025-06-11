package geomedicos.modelo.dto;

import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;

import geomedicos.modelo.entities.Cita;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class CitaDto {
	
	private int idCita;

	private LocalDate fecha;

	private int idHorario;

	private int idUsuario;
	
	public static CitaDto convertToCitaDto(Cita cita) {
		
		ModelMapper model = new ModelMapper();
		CitaDto citaDto =  model.map(cita, CitaDto.class);
		citaDto.setIdHorario(cita.getHorariosMedico().getIdHorario());
		citaDto.setIdUsuario(cita.getPaciente().getIdUsuario());
		return citaDto;
		
		
	}
	
	
	
	public static List<CitaDto> convertList(List<Cita> citas) {
		
		return citas.stream()
				.map(ele -> CitaDto.convertToCitaDto(ele))
				.toList();
		
	}

}
