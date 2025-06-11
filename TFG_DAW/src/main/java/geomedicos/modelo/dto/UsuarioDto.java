package geomedicos.modelo.dto;

import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;

import geomedicos.modelo.entities.Enfermedad;
import geomedicos.modelo.entities.Medico;
import geomedicos.modelo.entities.Usuario;
import geomedicos.modelo.enumerados.Genero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@EqualsAndHashCode(of = "idUsuario")
public class UsuarioDto {
	
	private int idUsuario;
	private String nombre;
	private String apellidos;
	private Genero genero;
	private String correo;
	private String telefono;
	private LocalDate fechaNacimiento;
	private String role;
	
	
	public static UsuarioDto convertToUsuarioDto(Usuario usuario) {
		
		ModelMapper model = new ModelMapper();
		return model.map(usuario, UsuarioDto.class);
		
		
	}
	
	public static List<UsuarioDto> convertList(List<Usuario> usuarios) {
		
		return usuarios.stream()
				.map(ele -> UsuarioDto.convertToUsuarioDto(ele))
				.toList();
		
	}


}
