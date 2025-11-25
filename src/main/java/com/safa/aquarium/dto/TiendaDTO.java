package com.safa.aquarium.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TiendaDTO {

    private Integer id;
    private String nombre;
    private String direccion;
}
