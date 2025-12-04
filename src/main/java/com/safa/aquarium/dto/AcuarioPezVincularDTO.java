package com.safa.aquarium.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AcuarioPezVincularDTO {

    @NotNull
    private Integer idAcuario;

    @NotNull
    private Integer idPez;


    @NotNull
    @Positive
    private Integer cantidad;


    private Integer cantidadMacho;
    private Integer cantidadHembra;
}
