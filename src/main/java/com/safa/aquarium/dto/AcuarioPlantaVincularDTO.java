package com.safa.aquarium.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AcuarioPlantaVincularDTO {

    @NotNull
    private Integer idAcuario;

    @NotNull
    private Integer idPlanta;
}
