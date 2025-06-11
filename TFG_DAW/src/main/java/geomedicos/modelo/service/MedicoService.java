package geomedicos.modelo.service;

import java.time.LocalDate;
import java.util.List;

import geomedicos.modelo.entities.Medico;

public interface MedicoService extends IntGenericoService<Medico, String>{
	
	Medico buscarPorColegiado(String colegiado);
	List<Medico> buscarPorEspecialidad(int idEspecialidad);
	List<Medico> buscarDisponiblesPorEspecialidadYFecha(int idEspecialidad, LocalDate fecha);
	
	Medico buscarPorCorreo(String correo);
	Medico buscarPorIdUsuario(int idUsuario);
	

}
