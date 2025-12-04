package com.safa.aquarium.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AcuarioPezDTO {

    private Integer id;
    private PezDTO pez;
    private Integer cantidad;
    private Integer cantidadHembra;
    private Integer cantidadMacho;

}
