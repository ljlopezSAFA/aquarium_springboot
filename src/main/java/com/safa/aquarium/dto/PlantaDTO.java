package com.safa.aquarium.dto;

import com.safa.aquarium.modelos.TipoPlanta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlantaDTO {

    private Integer id;

    private String nombre;

    private String ficha;
    private TipoPlanta tipoPlanta;
}
