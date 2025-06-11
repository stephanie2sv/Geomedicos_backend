package geomedicos.modelo.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import geomedicos.modelo.enumerados.DiaSemana;
import geomedicos.modelo.enumerados.EstadoCita;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@EqualsAndHashCode(of = "idHorario")

/**
 * The persistent class for the horarios_medicos database table.
 * 
 */
@Entity
@Table(name="horarios_medicos")
public class HorariosMedico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_horario")
	private int idHorario;
	
	@ManyToOne
	@JoinColumn(name="colegiado")
	private Medico medico;

	@Column(name="fecha_cita")
	@Temporal(TemporalType.DATE)
	private LocalDate fechaCita;

	@Column(name="hora_inicio")
	@Temporal(TemporalType.TIME)
	private LocalTime horaInicio;
	
	@Enumerated(EnumType.STRING)
	private EstadoCita estado;

	

	//uni-directional many-to-one association to Clinica
	@ManyToOne
	@JoinColumn(name="id_clinica")
	private Clinica clinica;

	

	
	

}