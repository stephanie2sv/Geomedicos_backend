package geomedicos.modelo.entities;

import java.io.Serializable;
import java.time.LocalDate;

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
@EqualsAndHashCode(of = "idTratamiento")

/**
 * The persistent class for the tratamientos database table.
 * 
 */
@Entity
@Table(name="tratamientos")
public class Tratamiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tratamiento")
	private int idTratamiento;

	@Lob
	private String descripcion;

	private String nombre;

	//uni-directional many-to-one association to Especialidad
	@ManyToOne
	@JoinColumn(name="id_especialidad")
	private Especialidad especialidad;

	

}