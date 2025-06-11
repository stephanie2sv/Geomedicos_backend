package geomedicos.restcontroller.pruebasvarias;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



@RestController
@CrossOrigin(origins = "*")
public class FicheroController {
	
	@PostMapping("/medicos/subir")
	public String subirFicheros2(@RequestParam MultipartFile archivo){
	
	System.out.println("pasando por post");
		String nombreArchivo = archivo.getOriginalFilename();
		Path rutaArchivo = null;
	if (!archivo.isEmpty()) { 
		// OBTEHNER EL NOMBRE ORIGINAL DEL FICHERO
	 //	rutaArchivo = Paths.get("d:/sboot/imagenes")
	   	rutaArchivo = Paths.get("src//main//resources//static/imagenes")
					.resolve(nombreArchivo)
					.toAbsolutePath();
		
		try {
			Files.copy(archivo.getInputStream(), rutaArchivo);
			System.out.println("todo bien");
		}catch(IOException e) {
			System.err.println(e.getMessage());
		}


	}
	System.out.println(rutaArchivo);
	return "proceso completado";
	}
	
	
	

}
