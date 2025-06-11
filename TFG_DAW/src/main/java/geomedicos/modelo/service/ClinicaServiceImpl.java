package geomedicos.modelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import geomedicos.modelo.entities.Clinica;
import geomedicos.modelo.repository.ClinicaRepository;

@Service
public class ClinicaServiceImpl implements ClinicaService{
	
	@Autowired
	private ClinicaRepository crepo;

	@Override
	public List<Clinica> findAll() {
		// TODO Auto-generated method stub
		return crepo.findAll();
	}

	@Override
	public Clinica findById(Integer claveId) {
		// TODO Auto-generated method stub
		return crepo.findById(claveId).orElse(null);
	}

	@Override
	public Clinica insertOne(Clinica entity) {
		if (entity.getIdClinica() != 0 && crepo.existsById(entity.getIdClinica())) {
		throw new IllegalArgumentException("La clínica con ID " + entity.getIdClinica() + " ya existe");
	}
	return crepo.save(entity);
	}

	@Override
	public int updateOne(Clinica entity) {
		if (entity.getIdClinica() == 0 && crepo.existsById(entity.getIdClinica())) {
		return 0;
	}
	crepo.save(entity);
	return 1;
	}

	@Override
	public int deleteOne(Integer claveId) {
		if ( crepo.existsById(claveId)) {
		crepo.deleteById(claveId);
		return 1;
	}
	
		return 0;
	}

	@Override
	public List<Clinica> findByCiudad(String ciudad) {
		// TODO Auto-generated method stub
		return crepo.findByCiudadOrderByNombre(ciudad);
	}

	@Override
	public List<Clinica> findByCodigoPostal(String codigoPostal) {
		// TODO Auto-generated method stub
		return crepo.findByCodigoPostalStartingWithOrderByCiudad(codigoPostal);
	}
	
	

}
