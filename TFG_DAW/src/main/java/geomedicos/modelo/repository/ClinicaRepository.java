package geomedicos.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import geomedicos.modelo.entities.Clinica;

public interface ClinicaRepository extends JpaRepository<Clinica, Integer>{
	
	public List<Clinica> findByCiudadOrderByNombre(String ciudad);
	public List<Clinica> findByCodigoPostalStartingWithOrderByCiudad(String codigoPostal);
	
	

}
