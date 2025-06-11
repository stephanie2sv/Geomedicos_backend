package geomedicos.modelo.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

import geomedicos.modelo.enumerados.DiaSemana;
import geomedicos.modelo.enumerados.EstadoCita;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@EqualsAndHashCode(of = "idCita")

/**
 * The persistent class for the citas database table.
 * 
 */
@Entity
@Table(name="citas")

public class Cita implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cita")
	private int idCita;
	

	@Temporal(TemporalType.DATE)
	private LocalDate fecha;

	//bi-directional many-to-one association to HorariosMedico
	@ManyToOne
	@JoinColumn(name="id_horario")
	private HorariosMedico horariosMedico;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_paciente")
	private Usuario paciente;

	

}