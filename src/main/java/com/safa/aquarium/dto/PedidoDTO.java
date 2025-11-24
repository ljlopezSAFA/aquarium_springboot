package com.safa.aquarium.dto;

import lombok.Data;

import java.util.List;

@Data
public class PedidoDTO {

    private String codigoPedido;
    private String fechaPedido;
    private List<ProductoDTO> productos;

}
