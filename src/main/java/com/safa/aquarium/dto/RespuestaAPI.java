package com.safa.aquarium.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class RespuestaAPI<T> {

    private Integer codigoRespuesta;
    private List<String> errores;
    private T Datos;


}
