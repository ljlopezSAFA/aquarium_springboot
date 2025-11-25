package com.safa.aquarium.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CrearTiendaDTO {


    @NotBlank(message = "El campo nombre no puede estar vacío")
    private String nombre;
    private String direccion;
    private String foto;
    private String ciudad;
    @Min(value = 40000, message = "Los codigos postales tienen que ser mayores de 40000")
    @Max(value = 50000, message = "Los codigos postales tienen que ser menores de 50000")
    private Integer codigoPostal;
}
