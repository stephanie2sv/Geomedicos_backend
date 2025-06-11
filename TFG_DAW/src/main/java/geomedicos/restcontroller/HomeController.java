package geomedicos.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import geomedicos.modelo.dto.MedicoDto;
import geomedicos.modelo.dto.UsuarioDto;
import geomedicos.modelo.dto.UsuarioLoginDto;
import geomedicos.modelo.entities.Usuario;
import geomedicos.modelo.repository.UsuarioRepository;
import geomedicos.modelo.service.MedicoService;
import geomedicos.modelo.service.UsuarioService;

@RestController
@CrossOrigin(origins = "*")

public class HomeController {
	
	@Autowired
	private UsuarioService userv;
	
	@Autowired
	private MedicoService mserv;
	
	@PostMapping("/api/login")
    public ResponseEntity<?> login(@RequestBody UsuarioLoginDto usuarioDto) {
	  
		
        Usuario usuario = userv.buscarPorCorreoyPassword(usuarioDto.getCorreo(), usuarioDto.getPassword());
       
        
        if (usuario != null ){
        	if (usuario.getRole().equals("DOCTOR")) {
        		return ResponseEntity.status(200).body(MedicoDto.convertToMedicoDto(mserv.buscarPorIdUsuario(usuario.getIdUsuario())));
        	}else {
        		
        		return ResponseEntity.status(200).body(UsuarioDto.convertToUsuarioDto(usuario));
        		
        	}
    
        }
        return ResponseEntity.status(404).body("Usuario o password incorrectos");
    }
	
	
	
	

}
