package geomedicos.restcontroller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import geomedicos.modelo.dto.CitaDetalladaDto;
import geomedicos.modelo.dto.CitaDto;
import geomedicos.modelo.dto.HorarioMedicoDto;
import geomedicos.modelo.dto.MedicoDto;
import geomedicos.modelo.entities.Cita;
import geomedicos.modelo.entities.HorariosMedico;
import geomedicos.modelo.entities.Medico;
import geomedicos.modelo.enumerados.EstadoCita;
import geomedicos.modelo.service.CitaService;
import geomedicos.modelo.service.ClinicaService;
import geomedicos.modelo.service.HorariosMedicoService;
import geomedicos.modelo.service.MedicoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/medico")
public class MedicoRestController {
	
	@Autowired
	private MedicoService mserv;
	
	@Autowired
	private ClinicaService cliserv;
	
	@Autowired
	private CitaService citaserv;
	
	@Autowired
	private HorariosMedicoService horarioserv;
	
	@GetMapping("/citasProgramadas")
	public ResponseEntity<?> citasProgramadas(@RequestParam String  colegiado, @RequestParam LocalDate fechaInicio) {
	//	ResponseEntity.status(200).body(MedicoDto.convertToMedicoDto(medico));
		return ResponseEntity.status(200).body(HorarioMedicoDto.convertList(horarioserv.citasConFecha(colegiado, fechaInicio)));
		
	}
	
	
	@GetMapping("/especialidad/{idEspecialidad}")
	public ResponseEntity<?> uno(@PathVariable int idEspecialidad) {
	//	ResponseEntity.status(200).body(MedicoDto.convertToMedicoDto(medico));
		return ResponseEntity.status(200).body(mserv.buscarPorEspecialidad(idEspecialidad));
		
	}
	
	@GetMapping("/disponibles-especialidad-fecha/")
	public ResponseEntity<List<MedicoDto>> disponibles(@RequestParam int idEspecialidad, @RequestParam LocalDate fecha) {
	//	List<HorariosMedico> horarios =  horarioserv.getMedicosDisponiblesPorEspecialidadYFecha(idEspecialidad, fecha);
		List<Medico> medicos =  horarioserv.getMedicosDisponiblesPorEspecialidadYFecha(idEspecialidad, fecha).stream()
								.map(ele -> ele.getMedico())
								.distinct()
								.toList();

		return ResponseEntity.status(200).body(MedicoDto.convertList(medicos));
		
	}
	/*
	 * Muestra las citas que los pacientes han solicitado
	 * para un medico en una fecha determinada
	 * Salida CitaDto. 
	 */
	 
	@GetMapping("/miscitas-en-fecha")
	ResponseEntity<List<CitaDto>> citasMedicoFecha (@RequestParam String colegiado, @RequestParam LocalDate fecha){
		List<Cita> citas = citaserv.buscarCitasPorMedicoyFecha(colegiado, fecha);
		
		
		return ResponseEntity.status(200).body(CitaDto.convertList(citas));
	}
	 
	@GetMapping("/detalle/{colegiado}")
	public ResponseEntity<?> uno(@PathVariable String colegiado) {
		Medico medico = mserv.buscarPorColegiado(colegiado);
		
		if (medico != null)
			return ResponseEntity.status(200).body(MedicoDto.convertToMedicoDto(medico));
		else
			return ResponseEntity.status(404).body(null);
	}
	
	@PostMapping("/horario/alta")
	public ResponseEntity<?> altaHorarioMedico(@RequestBody HorarioMedicoDto horarioDto) {
		HorariosMedico horario = new HorariosMedico();
		horario.setClinica(cliserv.findById(horarioDto.getIdClinica()));
		horario.setMedico(mserv.findById(horarioDto.getColegiado()));
		horario.setFechaCita(horarioDto.getFechaCita());
		horario.setHoraInicio(horarioDto.getHoraInicio());
		horario.setEstado(EstadoCita.PENDIENTE);
		
		
		if (horarioserv.insertOne(horario) != null) {
			horarioDto.setIdHorario(horario.getIdHorario());
			return ResponseEntity.status(201).body(horarioDto);
		}
			
		else
			return ResponseEntity.status(409).body(null);
	}
	
	@GetMapping("/miscitas/{colegiado}")
	public ResponseEntity<List<CitaDetalladaDto>> getCitasMedico(@PathVariable String colegiado) {
    List<Cita> citas = citaserv.buscarCitaPorMedicoColegiado(colegiado);
	List<CitaDetalladaDto> resultado = citas.stream()
        .map(CitaDetalladaDto::fromEntity)
        .collect(Collectors.toList());

    return ResponseEntity.ok(resultado);
}

}
