package geomedicos.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import geomedicos.modelo.entities.Enfermedad;

public interface EnfermedadRepository extends JpaRepository<Enfermedad, Integer>{
	
	
	public List<Enfermedad> findByTratamientoIdTratamiento(int idTratamiento);
	public List<Enfermedad> findByNombreContainingOrderByNombre(String cadena);
	List<Enfermedad> findByTratamientoEspecialidadIdEspecialidad(int idEspecialidad);

}
