package geomedicos.modelo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import geomedicos.modelo.entities.Medico;
import geomedicos.modelo.repository.MedicoRepository;

@Service
public class MedicoServiceImpl implements MedicoService{
	@Autowired
	private MedicoRepository mrepo;

	@Override
	public Medico buscarPorColegiado(String colegiado) {
		// TODO Auto-generated method stub
		return mrepo.findById(colegiado).orElse(null);
	}

	@Override
	public List<Medico> buscarPorEspecialidad(int idEspecialidad) {
		// TODO Auto-generated method stub
		return mrepo.findByEspecialidadIdEspecialidad(idEspecialidad);
	}

	@Override
	public Medico buscarPorCorreo(String correo) {
		// TODO Auto-generated method stub
		return mrepo.findByUsuarioCorreo(correo);
	}

	@Override
	public Medico buscarPorIdUsuario(int idUsuario) {
		// TODO Auto-generated method stub
		return mrepo.findByUsuarioIdUsuario(idUsuario);
	}

	@Override
	public List<Medico> findAll() {
		// TODO Auto-generated method stub
		return mrepo.findAll();
	}

	@Override
	public Medico findById(String claveId) {
		// TODO Auto-generated method stub
		return mrepo.findById(claveId).orElse(null);
	}

	@Override
	public Medico insertOne(Medico entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateOne(Medico entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOne(String claveId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Medico> buscarDisponiblesPorEspecialidadYFecha(int idEspecialidad, LocalDate fecha) {
		// TODO Auto-generated method stub
		return null;
	}

}
