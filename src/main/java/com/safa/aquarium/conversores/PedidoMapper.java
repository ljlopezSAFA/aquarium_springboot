package com.safa.aquarium.conversores;

import com.safa.aquarium.dto.PedidoDTO;
import com.safa.aquarium.modelos.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDate;

@Mapper(componentModel = "spring")
public interface PedidoMapper {


    @Mapping(source = "fecha", target = "fechaPedido", qualifiedByName = "convertirFecha")
    @Mapping(source = "codigo", target = "codigoPedido")
    PedidoDTO toDTO(Pedido entity);



    @Named("convertirFecha")
    default String convertirAString(LocalDate localDate){
        return localDate.toString();
    }

}
