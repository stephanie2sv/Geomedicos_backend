package geomedicos.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import geomedicos.modelo.dto.EnfermedadDto;
import geomedicos.modelo.entities.Enfermedad;
import geomedicos.modelo.service.EnfermedadService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/enfermedades")
public class EnfermedadRestController {
	
	@Autowired
	private EnfermedadService eserv;
	
	@GetMapping("/especialidad/{idEspecialidad}")
	
	public ResponseEntity<List<EnfermedadDto>> especialidad(@PathVariable int idEspecialidad){
		
		return ResponseEntity.ok(EnfermedadDto.convertList(eserv.findByIdEspecialidad(idEspecialidad)));
		
	}
	
	
	@GetMapping("/nombre/{cadena}")
	
	public ResponseEntity<List<EnfermedadDto>> nombre(@PathVariable String cadena){
		
		return ResponseEntity.ok(EnfermedadDto.convertList(eserv.findByNombre(cadena)));
		
	}
	
	@GetMapping("/todas")
	
	public ResponseEntity<List<EnfermedadDto>> todas(){
		
		return ResponseEntity.ok(EnfermedadDto.convertList(eserv.findAll()));
		
	}
	
	@GetMapping("/una/{idEnfermedad}")
	
	public ResponseEntity<EnfermedadDto> una(@PathVariable int idEnfermedad){
		Enfermedad enfermedad = eserv.findById(idEnfermedad);
		return ResponseEntity.ok(EnfermedadDto.convert(enfermedad));
		
	}
	
@GetMapping("/tratamiento/{idTratamiento}")
	
	public ResponseEntity<List<EnfermedadDto>> porTratamiento(@PathVariable int idTratamiento){
		 
		return ResponseEntity.ok(EnfermedadDto.convertList(eserv.findByTratamiento(idTratamiento)));
		
	}
	

}
