package geomedicos.modelo.entities;

import java.io.Serializable;
import java.time.LocalDate;
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
@EqualsAndHashCode(of = "colegiado")

/**
 * The persistent class for the medicos database table.
 * 
 */
@Entity
@Table(name="medicos")
public class Medico implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String colegiado;

	private double tarifa;

	private String imagen;

	//uni-directional many-to-one association to Especialidad
	@OneToOne
	@JoinColumn(name="id_especialidad")
	private Especialidad especialidad;

	//uni-directional one-to-one association to Usuario
	@OneToOne
	@JoinColumn(name="ID_USUARIO", referencedColumnName="id_usuario")
	private Usuario usuario;

	//uni-directional many-to-many association to Tratamiento
		@ManyToMany(fetch = FetchType.LAZY)
		@JoinTable(
			name="medico_tratamientos"
			, joinColumns={
				@JoinColumn(name="colegiado")
				}
			, inverseJoinColumns={
				@JoinColumn(name="id_tratamiento")
				}
			)
		
		private List<Tratamiento> tratamientos;
}