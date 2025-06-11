package geomedicos.restcontroller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import geomedicos.modelo.dto.CitaDetalladaDto;
import geomedicos.modelo.dto.CitaDto;
import geomedicos.modelo.entities.Cita;
import geomedicos.modelo.entities.HorariosMedico;
import geomedicos.modelo.enumerados.EstadoCita;
import geomedicos.modelo.service.CitaService;
import geomedicos.modelo.service.HorariosMedicoService;
import geomedicos.modelo.service.UsuarioService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/paciente")
public class PacienteRestController {
	
	@Autowired
	private CitaService cserv;
	@Autowired
	private HorariosMedicoService mserv;
	@Autowired
	private UsuarioService userv;
	
@GetMapping("/miscitas/{idUsuario}")
public ResponseEntity<List<CitaDetalladaDto>> misCitas(@PathVariable int idUsuario) {
    List<Cita> citas = cserv.buscarCitasPorPaciente(idUsuario); // <- devuelve entidades Cita

    List<CitaDetalladaDto> resultado = citas.stream()
        .map(CitaDetalladaDto::fromEntity)
        .collect(Collectors.toList());

    return ResponseEntity.ok(resultado);
}
	
@PostMapping("/miscitas/alta")
public ResponseEntity<?> altaCita(@RequestBody CitaDto citadto){

    Cita cita = new Cita();
    HorariosMedico horario = mserv.findById(citadto.getIdHorario());

    // Verificación: evitar doble reserva
    if (horario.getEstado() == EstadoCita.CONFIRMADA) {
        return ResponseEntity.status(409).body("Ese horario ya ha sido reservado.");
    }

	if (cserv.existeHorariosMedico(horario)) {
    return ResponseEntity.status(409).body("Ya existe una cita para ese horario.");
}

boolean yaTieneCitaEseHorario = cserv.existeCitaDuplicada(citadto.getIdUsuario(),horario.getIdHorario(),horario.getFechaCita());

    if (yaTieneCitaEseHorario) {
        return ResponseEntity.status(409).body("Ya tienes una cita en ese horario.");
    }

    cita.setFecha(horario.getFechaCita());
    cita.setHorariosMedico(horario);
    cita.setPaciente(userv.findById(citadto.getIdUsuario()));
    horario.setEstado(EstadoCita.CONFIRMADA);

    if (cserv.insertOne(cita) != null) {
        citadto.setIdCita(cita.getIdCita());
        mserv.updateOne(horario);
        return ResponseEntity.status(201).body(citadto);
    } else {
        return ResponseEntity.status(409).body(null);
    }
}
	
	@DeleteMapping("/miscitas/eliminar/{idCita}")
	public ResponseEntity<?> eliminarCita(@PathVariable int idCita){
		
			
			HorariosMedico horario = mserv.findById(cserv.findById(idCita).getHorariosMedico().getIdHorario());
			horario.setEstado(EstadoCita.PENDIENTE);
			
			cserv.deleteOne(idCita);
			mserv.updateOne(horario);
			return ResponseEntity.status(200).body("citaEliminada");
		
		
	}

}
