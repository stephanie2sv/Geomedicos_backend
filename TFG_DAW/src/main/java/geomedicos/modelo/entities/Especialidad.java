package geomedicos.modelo.entities;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@EqualsAndHashCode(of = "idEspecialidad")

/**
 * The persistent class for the especialidades database table.
 * 
 */
@Entity
@Table(name="especialidades")
public class Especialidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_especialidad")
	private int idEspecialidad;

	private String nombre;
/*
	//uni-directional many-to-many association to Clinica
	@ManyToMany
	@JoinTable(
		name="clinica_especialidad"
		, joinColumns={
			@JoinColumn(name="id_especialidad")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_clinica")
			}
		)
	private List<Clinica> clinica;

	*/

}