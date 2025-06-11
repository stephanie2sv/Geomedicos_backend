package geomedicos.modelo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import geomedicos.modelo.entities.HorariosMedico;
import geomedicos.modelo.entities.Medico;
import geomedicos.modelo.enumerados.EstadoCita;
import geomedicos.modelo.repository.HorariosMedicoRepository;
@Service
public class HorariosMedicoServiceImpl implements HorariosMedicoService{
	
	@Autowired
	private HorariosMedicoRepository hrepo;

	@Override
	public List<HorariosMedico> findAll() {
		// TODO Auto-generated method stub
		return hrepo.findAll();
	}

	@Override
	public HorariosMedico findById(Integer claveId) {
		// TODO Auto-generated method stub
		return hrepo.findById(claveId).orElse(null);
	}

	@Override
	public HorariosMedico insertOne(HorariosMedico entity) {
		try {
			return hrepo.save(entity);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int updateOne(HorariosMedico entity) {
		try {
			if (hrepo.existsById(entity.getIdHorario())) {
				hrepo.save(entity);
				return 1;
			} else
				return 0;
		}catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public int deleteOne(Integer claveId) {
		HorariosMedico horario = findById(claveId);
		try {
			if (horario != null) {
				hrepo.delete(horario);
				return 1;
			} else
				return 0;
		}catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
	}



	@Override
	public List<HorariosMedico> getMedicosDisponiblesPorEspecialidadYFecha(int idEspecialidad, LocalDate fecha) {
		// TODO Auto-generated method stub
		return hrepo.findByMedicoEspecialidadIdEspecialidadAndFechaCitaGreaterThanAndEstado(idEspecialidad, fecha, EstadoCita.PENDIENTE);
	}

	@Override
	public List<HorariosMedico> citasConFecha(String colegiado, LocalDate fechaInicio) {
		return hrepo.findByMedicoColegiadoAndFechaCita(colegiado,fechaInicio);
	}

}
