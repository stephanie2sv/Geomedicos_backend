package geomedicos.restcontroller;

import java.util.List;
import java.util.Objects;
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

import geomedicos.modelo.dto.ClinicaDto;
import geomedicos.modelo.entities.Clinica;
import geomedicos.modelo.entities.Especialidad;
import geomedicos.modelo.service.ClinicaService;
import geomedicos.modelo.service.EspecialidadService;



@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/clinicas")
public class ClinicaRestController {
	@Autowired
	private ClinicaService cserv;

	@Autowired
	private EspecialidadService especialidadService;
	
	@GetMapping("/codigoPostal/{codigo}")
	
	public ResponseEntity<List<Clinica>> codigoPostal(@PathVariable String codigo){
		
		return ResponseEntity.ok(cserv.findByCodigoPostal(codigo));
		
	}
	
	@GetMapping("/todas")
	
	public ResponseEntity<List<Clinica>> todas(){
		
		return ResponseEntity.ok(cserv.findAll());
		
	}
	
	@GetMapping("/ciudad/{ciudad}")
	
	public ResponseEntity<List<Clinica>> nombre(@PathVariable String ciudad){
		
		return ResponseEntity.ok(cserv.findByCiudad(ciudad));
		
	}
	
	@GetMapping("/{idClinica}")
	
	public ResponseEntity<Clinica> una(@PathVariable int idClinica){
		
		return ResponseEntity.ok(cserv.findById(idClinica));
		
	}
@PostMapping("/alta")
public ResponseEntity<?> crearClinica(@RequestBody ClinicaDto dto) {
    if (dto.getNombre() == null || dto.getNombre().trim().isEmpty()) {
        return ResponseEntity.badRequest().body("El nombre de la clínica es obligatorio");
    }

    Clinica clinica = new Clinica();
    clinica.setNombre(dto.getNombre());
    clinica.setDireccion(dto.getDireccion());
    clinica.setCiudad(dto.getCiudad());
    clinica.setCodigoPostal(dto.getCodigoPostal());

    List<Especialidad> especialidades = dto.getEspecialidades().stream()
        .map(id -> especialidadService.findById(id))
        .filter(Objects::nonNull)
        .collect(Collectors.toList());

    clinica.setEspecialidades(especialidades);

    Clinica creada = cserv.insertOne(clinica); 
    return ResponseEntity.status(201).body(ClinicaDto.fromEntity(creada)); 
}


	@DeleteMapping("/{idClinica}")
	public ResponseEntity<?> eliminarClinica(@PathVariable int idClinica) {
    Clinica clinica = cserv.findById(idClinica);
    if (clinica == null) {
        return ResponseEntity.status(404).body("Clínica no encontrada");
    }

    cserv.deleteOne(idClinica);
    return ResponseEntity.ok().body("Clínica eliminada correctamente");
}

}
