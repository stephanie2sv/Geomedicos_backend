package geomedicos.modelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import geomedicos.modelo.entities.Usuario;
import geomedicos.modelo.repository.UsuarioRepository;
@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository urepo;

	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return urepo.findAll();
	}

	@Override
	public Usuario findById(Integer claveId) {
		// TODO Auto-generated method stub
		return urepo.findById(claveId).orElse(null);
	}

	@Override
	public Usuario insertOne(Usuario entity) {
		try {
			return urepo.save(entity);
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int updateOne(Usuario entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOne(Integer claveId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Usuario buscarPorCorreoyPassword(String correo, String password) {
		// TODO Auto-generated method stub
		return urepo.findByCorreoAndPassword(correo, password);
	}

	@Override
	public Usuario buscarPorCorreo(String correo) {
		// TODO Auto-generated method stub
		return urepo.findByCorreo(correo);
	}
	
	
	

}
