package geomedicos.restcontroller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import geomedicos.modelo.entities.Usuario;
import geomedicos.modelo.service.UsuarioService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
	private UsuarioService userv;

    @GetMapping("/")
    public ResponseEntity<List<Usuario>> obtenerTodos() {
    List<Usuario> usuarios = userv.findAll();
    return ResponseEntity.ok(usuarios);
    }

    @PutMapping("/{idUsuario}/estado")
    public ResponseEntity<?> cambiarEstadoUsuario(@PathVariable int idUsuario, @RequestParam int enabled) {
    Usuario usuario = userv.findById(idUsuario);
    if (usuario == null) {
        return ResponseEntity.notFound().build();
    }
    
     if (enabled != 0 && enabled != 1) {
    return ResponseEntity.badRequest().body("Valor inválido para enabled (debe ser 0 o 1)");
    
    }
    usuario.setEnabled(enabled);
    userv.updateOne(usuario);

   
    return ResponseEntity.ok().body(Map.of("mensaje", "Estado actualizado a " + enabled));
    }

    @GetMapping("/porCorreo")
    public ResponseEntity<?> buscarPorCorreo(@RequestParam String correo) {
    Usuario usuario = userv.buscarPorCorreo(correo);
    
    if (usuario == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró ningún usuario con ese correo");
    }

    return ResponseEntity.ok(usuario);
}

}
