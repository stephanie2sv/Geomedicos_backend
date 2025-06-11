package geomedicos.restcontroller.pruebasvarias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import geomedicos.modelo.dto.MedicoDto;
import geomedicos.modelo.entities.Medico;
import geomedicos.modelo.repository.MedicoRepository;

@RestController
@CrossOrigin(origins = "*")
public class PruebaMedicoDto {
	@Autowired
	private MedicoRepository mrepo;
	@GetMapping("/medico/uno")
	public MedicoDto uno() {
		Medico med = mrepo.findById("11111111A").orElse(null);
		return MedicoDto.convertToMedicoDto(med);
	}
	

}
