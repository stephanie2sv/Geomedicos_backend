package geomedicos.modelo.service;

import geomedicos.modelo.entities.Usuario;

public interface UsuarioService extends IntGenericoService<Usuario, Integer>{
	
	Usuario buscarPorCorreoyPassword(String correo, String password);
	Usuario buscarPorCorreo(String correo);

}
