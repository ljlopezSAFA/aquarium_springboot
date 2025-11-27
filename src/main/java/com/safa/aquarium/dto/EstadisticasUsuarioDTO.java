package com.safa.aquarium.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstadisticasUsuarioDTO {
    private Integer usuario;
    private String nombre_usuario;
    private Long num_acuarios;
}
