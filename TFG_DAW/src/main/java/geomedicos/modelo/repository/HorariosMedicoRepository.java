package geomedicos.modelo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import geomedicos.modelo.entities.HorariosMedico;
import geomedicos.modelo.enumerados.EstadoCita;

public interface HorariosMedicoRepository extends JpaRepository<HorariosMedico, Integer>{
	
	public List<HorariosMedico> findByMedicoColegiadoAndFechaCita(String colegiado, LocalDate fechaInicio);
	public List<HorariosMedico> findByMedicoEspecialidadIdEspecialidadAndFechaCitaGreaterThanAndEstado(int idEspecialidad, LocalDate fecha, EstadoCita estado);
	
	public List<HorariosMedico> findByMedicoColegiadoAndFechaCitaAndEstado(String colegiado, LocalDate fechaCita, EstadoCita estado);

}
