package geomedicos.modelo.service;

import java.util.List;

import geomedicos.modelo.entities.Clinica;

public interface ClinicaService extends IntGenericoService<Clinica, Integer>{
	
	List<Clinica> findByCiudad(String ciudad);
	List<Clinica> findByCodigoPostal(String codigoPostal);
	
	

}
