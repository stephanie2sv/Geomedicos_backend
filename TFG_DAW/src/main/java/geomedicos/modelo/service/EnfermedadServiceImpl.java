package geomedicos.modelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import geomedicos.modelo.entities.Enfermedad;
import geomedicos.modelo.repository.EnfermedadRepository;

@Service
public class EnfermedadServiceImpl implements EnfermedadService{
	@Autowired
	private EnfermedadRepository erepo;

	@Override
	public List<Enfermedad> findAll() {
		// TODO Auto-generated method stub
		return erepo.findAll();
	}

	@Override
	public Enfermedad findById(Integer claveId) {
		// TODO Auto-generated method stub
		return erepo.findById(claveId).orElse(null);
	}

	@Override
	public Enfermedad insertOne(Enfermedad entity) {
		// TODO Auto-generated method stub
		return erepo.save(entity);
	}

	@Override
	public int updateOne(Enfermedad entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOne(Integer claveId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Enfermedad> findByTratamiento(int idTratamiento) {
		// TODO Auto-generated method stub
		return erepo.findByTratamientoIdTratamiento(idTratamiento);
	}

	@Override
	public List<Enfermedad> findByNombre(String cadena) {
		// TODO Auto-generated method stub
		return erepo.findByNombreContainingOrderByNombre(cadena);
	}

	@Override
	public List<Enfermedad> findByIdEspecialidad(int idEspecialidad) {
		// TODO Auto-generated method stub
		return erepo.findByTratamientoEspecialidadIdEspecialidad(idEspecialidad);
	}
	
	
	
	
	

}
