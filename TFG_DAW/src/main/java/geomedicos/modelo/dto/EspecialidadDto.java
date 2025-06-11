package geomedicos.modelo.dto;

import java.time.LocalDate;
import java.util.List;

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
public class EspecialidadDto {
	private int idEspecialidad;
	private String nombre;
	

}
