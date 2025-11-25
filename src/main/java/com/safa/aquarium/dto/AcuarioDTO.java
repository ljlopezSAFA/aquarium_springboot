package com.safa.aquarium.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class AcuarioDTO {
    private Integer id;
    private Double capacidad;
    private String medidas;
    private UsuarioDTO usuario;
    private Set<PlantaDTO> plantas;
}
