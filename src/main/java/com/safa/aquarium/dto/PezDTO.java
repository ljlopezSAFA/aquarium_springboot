package com.safa.aquarium.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PezDTO {

    private Integer id;
    private String nombreComun;
    private String foto;
    private String descripcion;

}
