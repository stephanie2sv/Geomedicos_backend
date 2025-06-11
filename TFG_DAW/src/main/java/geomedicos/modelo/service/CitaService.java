package geomedicos.modelo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.query.Param;

import geomedicos.modelo.entities.Cita;
import geomedicos.modelo.entities.HorariosMedico;

public interface CitaService extends IntGenericoService<Cita, Integer> {
	
	List<Cita> buscarCitaPorMedicoColegiado(@Param("colegiado") String colegiado);
	boolean existeHorariosMedico(HorariosMedico horario);
	List<Cita> buscarCitasPorPaciente(int idPaciente);
	List<Cita> buscarCitasPorMedicoyFecha(String colegiado, LocalDate fechaCita);
	boolean existeCitaDuplicada(int idUsuario, int idHorario, LocalDate fecha);
	
	
	
	
	
	

}
