package geomedicos.modelo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import geomedicos.modelo.entities.Cita;
import geomedicos.modelo.entities.HorariosMedico;
import geomedicos.modelo.repository.CitaRepository;
@Service
public class CitaServiceImpl implements CitaService{
	
	@Autowired
	private CitaRepository crepo;

	@Override
	public List<Cita> findAll() {
		// TODO Auto-generated method stub
		return crepo.findAll();
	}

	@Override
	public Cita findById(Integer claveId) {
		// TODO Auto-generated method stub
		return crepo.findById(claveId).orElse(null);
	}

	@Override
	public Cita insertOne(Cita entity) {
		try {
			return crepo.save(entity);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int updateOne(Cita entity) {
		try {
			if (crepo.existsById(entity.getIdCita())) {
				crepo.save(entity);
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
		Cita cita = findById(claveId);
		try {
			if (cita != null) {
				crepo.delete(cita);
				return 1;
			} else
				return 0;
		}catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public List<Cita> buscarCitasPorPaciente(int idPaciente) {
		// TODO Auto-generated method stub
		return crepo.findByPacienteIdUsuario(idPaciente);
	}
	/*
	 * Obtenemos las citas que los pacientes han solicitado
	 * para un medico en una fecha determinada
	 */
	@Override
	public List<Cita> buscarCitasPorMedicoyFecha(String colegiado, LocalDate fechaCita) {
		// TODO Auto-generated method stub
		return crepo.findByHorariosMedicoMedicoColegiadoAndHorariosMedicoFechaCita(colegiado, fechaCita);
	}

	@Override
	public boolean existeHorariosMedico(HorariosMedico horario) {
	return crepo.existsByHorariosMedico(horario);
	}

	@Override
	public List<Cita> buscarCitaPorMedicoColegiado(String colegiado) {
	return crepo.findByMedicoColegiado(colegiado);
	}

	@Override
	public boolean existeCitaDuplicada(int idUsuario, int idHorario, LocalDate fecha) {
		
		return crepo.existsByPacienteAndHorarioAndFecha(idUsuario,idHorario,fecha);
	}

}
