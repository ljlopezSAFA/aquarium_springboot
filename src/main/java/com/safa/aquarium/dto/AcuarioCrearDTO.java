package com.safa.aquarium.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AcuarioCrearDTO {

    private Integer id;

    @Min(value = 10, message = "La capacidad debe ser mayor a 10L")
    private Double capacidad;
    private String medidas;

    @NotNull(message = "Debes de indicar un id usuario")
    private Integer idUsuario;
}
