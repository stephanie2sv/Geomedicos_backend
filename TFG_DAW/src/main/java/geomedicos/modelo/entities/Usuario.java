package geomedicos.modelo.entities;

import java.io.Serializable;
import java.time.LocalDate;

import geomedicos.modelo.enumerados.Genero;
import geomedicos.modelo.enumerados.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@EqualsAndHashCode(of = "idUsuario")

/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Table(name="usuarios")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private int idUsuario;
	private String nombre;
	private String apellidos;
	private String correo;
	private int enabled;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_ALTA")
	private LocalDate fechaAlta;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_nacimiento")
	private LocalDate fechaNacimiento;
	@Enumerated(EnumType.STRING)
	private Genero genero;

	private String password;
	
	private String role;

	private String telefono;

	

	
}