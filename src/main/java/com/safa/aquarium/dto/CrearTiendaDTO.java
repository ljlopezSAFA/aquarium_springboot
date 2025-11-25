package com.safa.aquarium.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CrearTiendaDTO {
    private String nombre;
    private String direccion;
    private String foto;
    private String ciudad;
    private Integer codigoPostal;
}
