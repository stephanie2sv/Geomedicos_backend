package geomedicos.modelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import geomedicos.modelo.entities.Especialidad;
import geomedicos.modelo.repository.EspecialidadRepository;

@Service
public class EspecialidadServiceImpl implements EspecialidadService{
	
	@Autowired
	private EspecialidadRepository erepo;

	@Override
	public List<Especialidad> findAll() {
		// TODO Auto-generated method stub
		return erepo.findAll();
	}

	@Override
	public Especialidad findById(Integer claveId) {
		// TODO Auto-generated method stub
		return erepo.findById(claveId).orElse(null);
	}

	@Override
	public Especialidad insertOne(Especialidad entity) {
		if (entity.getIdEspecialidad() != 0 && erepo.existsById(entity.getIdEspecialidad())) {
		throw new IllegalArgumentException("La especialidad con ID " + entity.getIdEspecialidad() + " ya existe");
	}
	return erepo.save(entity);
	}

	@Override
	public int updateOne(Especialidad entity) {
		if (entity.getIdEspecialidad() == 0 && erepo.existsById(entity.getIdEspecialidad())) {
		return 0;
	}
	erepo.save(entity);
	return 1;
	}

	@Override
	public int deleteOne(Integer claveId) {
		if (erepo.existsById(claveId)) {
			erepo.deleteById(claveId);
		return 1;
	}
	
	return 0;
	}

	@Override
	public List<Especialidad> findByNombre(String cadena) {
		// TODO Auto-generated method stub
		return erepo.findByNombreContainingOrderByNombre(cadena);
	}

}
