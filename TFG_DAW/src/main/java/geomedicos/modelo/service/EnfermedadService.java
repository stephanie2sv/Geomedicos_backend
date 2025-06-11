package geomedicos.modelo.service;

import java.util.List;

import geomedicos.modelo.entities.Enfermedad;

public interface EnfermedadService extends IntGenericoService<Enfermedad, Integer>{
	
	 
	List<Enfermedad> findByTratamiento(int idTratamiento);
	List<Enfermedad> findByNombre(String cadena);
	List<Enfermedad> findByIdEspecialidad(int idEspecialidad);
	
	 
	

}
