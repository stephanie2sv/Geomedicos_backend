package geomedicos.modelo.service;

import java.util.List;

import geomedicos.modelo.entities.Especialidad;

public interface EspecialidadService extends IntGenericoService<Especialidad, Integer>{
	
	List<Especialidad> findByNombre(String cadena);

}
