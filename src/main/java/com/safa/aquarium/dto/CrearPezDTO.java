package com.safa.aquarium.dto;


import com.safa.aquarium.modelos.Especie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CrearPezDTO {
    private String nombre;
    private String foto;
    private String ficha;
    private Especie especie;
    private String descripcion;

}
