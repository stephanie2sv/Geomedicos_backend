package geomedicos.modelo.dto;

import java.util.List;

import org.modelmapper.ModelMapper;

import geomedicos.modelo.entities.Enfermedad;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EnfermedadDto {
	
	private int idEnfermedad;
	private String nombre;
	private int idTratamiento;
	private String nombreTratamiento;
	private String descripcionTratamiento;
	private int idEspecialidad;
	private String nombreEspecialidad;
	
	
	public static EnfermedadDto convert(Enfermedad enfermedad) {
		
		ModelMapper maper = new ModelMapper();
		
		EnfermedadDto edto =  maper.map(enfermedad, EnfermedadDto.class);
		
		edto.setIdEspecialidad(enfermedad.getTratamiento().getEspecialidad().getIdEspecialidad());
		edto.setNombreEspecialidad(enfermedad.getTratamiento().getEspecialidad().getNombre());
		return edto;
		
	}
	
	public static List<EnfermedadDto> convertList(List<Enfermedad> enfermedades) {
		
		return enfermedades.stream()
				.map(ele -> EnfermedadDto.convert(ele))
				.toList();
		
	}
	
	
}
