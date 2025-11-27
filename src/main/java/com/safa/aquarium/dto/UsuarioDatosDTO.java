package com.safa.aquarium.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDatosDTO {
    private Integer id;
    private String mail;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String dni;
    private List<AcuarioDTO> acuarios;


}
