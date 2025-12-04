package com.safa.aquarium.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AcuarioDetalleDTO {
    private Integer id;
    private String nombre;
    private String descripcion;
    private String foto;
    private Double capacidad;
    private String medidas;
    private UsuarioDTO usuario;
    private Set<PlantaDTO> plantas;
    private Set<AcuarioPezDTO> peces;
}
