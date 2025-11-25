package com.safa.aquarium.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TiendasPorCiudad {
    private String nombreCiudad;
    private Integer numTiendas;
}
