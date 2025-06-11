package geomedicos.modelo.entities;

import java.io.Serializable;
import java.util.List;

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
@EqualsAndHashCode(of = "idClinica")

/**
 * The persistent class for the clinicas database table.
 * 
 */
@Entity
@Table(name="clinicas")
public class Clinica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_clinica")
	private int idClinica;

	private String ciudad;

	@Column(name="codigo_postal")
	private String codigoPostal;

	private String direccion;

	private String nombre;


	//uni-directional many-to-many association to Especialidad
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name="clinica_especialidad"
		, joinColumns={
			@JoinColumn(name="id_clinica")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_especialidad")
			}
		)
	private List<Especialidad> especialidades;

}