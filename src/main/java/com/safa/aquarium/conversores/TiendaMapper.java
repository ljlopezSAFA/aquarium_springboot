package com.safa.aquarium.conversores;

import com.safa.aquarium.dto.CrearTiendaDTO;
import com.safa.aquarium.dto.TiendaDTO;
import com.safa.aquarium.modelos.Tienda;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface TiendaMapper {


    TiendaDTO toTiendaDTO(Tienda t);

    List<TiendaDTO> toTiendaDTO(List<Tienda> t);


    @Mapping(source = "foto", target = "urlLogo")
    Tienda toEntity(CrearTiendaDTO dto);




    @Mapping(source = "urlLogo", target = "foto")
    CrearTiendaDTO toDTO(Tienda tienda);



}
