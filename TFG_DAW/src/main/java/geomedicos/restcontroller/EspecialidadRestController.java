package geomedicos.restcontroller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import geomedicos.modelo.dto.EspecialidadDto;
import geomedicos.modelo.entities.Especialidad;
import geomedicos.modelo.service.EspecialidadService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/especialidades")
public class EspecialidadRestController {
	
	@Autowired
	private EspecialidadService eserv;
	
	@GetMapping("/todas")
	public ResponseEntity<List<Especialidad>> todas() {
		 return ResponseEntity.ok(eserv.findAll());
	}
	
	@GetMapping("/nombre/{cadena}")
	public ResponseEntity<List<Especialidad>> nombre(@PathVariable String cadena) {
		 return ResponseEntity.ok(eserv.findByNombre(cadena));
	}

	@GetMapping("/{idEspecialidad}")
	public ResponseEntity<Especialidad> getEspecialidadById(@PathVariable int idEspecialidad) {
    	Especialidad especialidad = eserv.findById(idEspecialidad);
   		 return ResponseEntity.ok(especialidad);
}
	    @PostMapping("/alta")
    	public ResponseEntity<?> crear(@RequestBody Map<String, String> body) {
        String nombre = body.get("nombre");
        if (nombre == null || nombre.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("El nombre es obligatorio");
        }

        Especialidad esp = new Especialidad();
        esp.setNombre(nombre);
        eserv.insertOne(esp);
        return ResponseEntity.status(201).body("Especialidad creada correctamente");
    }

	 @DeleteMapping("/{idEspecialidad}")
    public ResponseEntity<?> eliminar(@PathVariable int idEspecialidad) {
        Especialidad esp = eserv.findById(idEspecialidad);
        if (esp == null) {
            return ResponseEntity.status(404).body("No encontrada");
        }

        eserv.deleteOne(idEspecialidad);
        return ResponseEntity.ok("Eliminada correctamente");
    }
}
