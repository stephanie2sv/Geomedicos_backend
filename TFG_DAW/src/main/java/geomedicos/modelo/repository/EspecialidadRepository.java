package geomedicos.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import geomedicos.modelo.entities.Especialidad;
import geomedicos.modelo.entities.Medico;

public interface EspecialidadRepository extends JpaRepository<Especialidad, Integer>{
	
	public List<Especialidad> findByNombreContainingOrderByNombre(String cadena);


}
