package geomedicos.modelo.dto;

import java.util.List;
import java.util.stream.Collectors;

import geomedicos.modelo.entities.Clinica;
import geomedicos.modelo.entities.Especialidad;
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
public class ClinicaDto {
    private int idClinica;
    private String nombre;
    private String direccion;
    private String ciudad;
    private String codigoPostal;
    private List<Integer> especialidades;

    public static ClinicaDto fromEntity(Clinica c) {
        return ClinicaDto.builder()
            .idClinica(c.getIdClinica())
            .nombre(c.getNombre())
            .direccion(c.getDireccion())
            .ciudad(c.getCiudad())
            .codigoPostal(c.getCodigoPostal())
            .especialidades(
                c.getEspecialidades().stream()
                    .map(Especialidad::getIdEspecialidad)
                    .collect(Collectors.toList())
            )
            .build();
    }
}