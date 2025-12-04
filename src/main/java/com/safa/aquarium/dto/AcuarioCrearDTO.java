package com.safa.aquarium.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AcuarioCrearDTO {


    @Min(value = 10, message = "La capacidad debe ser mayor a 10L")
    @Max(value = 80, message = "La capacidad no puede ser mayor de 80L")
    private Double capacidad;

    private String medidas;

    private String descripcion;

    @NotBlank
    private String nombre;

    @NotNull
    private String foto;



    @NotNull(message = "Debes de indicar un id usuario")
    private Integer idUsuario;
}
