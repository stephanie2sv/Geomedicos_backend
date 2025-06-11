package geomedicos.modelo.service;

import java.time.LocalDate;
import java.util.List;

import geomedicos.modelo.entities.HorariosMedico;


public interface HorariosMedicoService extends IntGenericoService<HorariosMedico, Integer>{
	
	List<HorariosMedico> citasConFecha(String colegiado, LocalDate fechaInicio);
	
	List<HorariosMedico>  getMedicosDisponiblesPorEspecialidadYFecha(int idEspecialidad, LocalDate fecha);

}
