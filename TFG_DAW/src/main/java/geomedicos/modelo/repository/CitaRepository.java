package geomedicos.modelo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import geomedicos.modelo.entities.Cita;
import geomedicos.modelo.entities.HorariosMedico;


public interface CitaRepository extends JpaRepository<Cita, Integer>{

	@Query("SELECT c FROM Cita c WHERE c.horariosMedico.medico.colegiado = :colegiado")
	List<Cita> findByMedicoColegiado(@Param("colegiado") String colegiado);

	@Query("SELECT COUNT(c) > 0 FROM Cita c " +
       "WHERE c.paciente.idUsuario = :idUsuario " +
       "AND c.horariosMedico.idHorario = :idHorario " +
       "AND c.fecha = :fecha")
	boolean existsByPacienteAndHorarioAndFecha(@Param("idUsuario") int idUsuario,
                                           @Param("idHorario") int idHorario,
                                           @Param("fecha") LocalDate fecha);


	boolean existsByHorariosMedico(HorariosMedico horario);
	List<Cita>  findByPacienteIdUsuario(int idusuario); 
	List<Cita>  findByHorariosMedicoMedicoColegiadoAndHorariosMedicoFechaCita(String colegiado, LocalDate fechaCita);
	
	 
	

}
