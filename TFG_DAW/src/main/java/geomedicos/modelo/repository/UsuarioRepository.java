package geomedicos.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import geomedicos.modelo.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	
	public Usuario findByCorreoAndPassword(String correo, String password);
	public Usuario findByCorreo(String correo);
	
	
	

}
