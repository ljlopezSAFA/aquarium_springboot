package com.safa.aquarium.conversores;

import com.safa.aquarium.dto.AcuarioDTO;
import com.safa.aquarium.modelos.Acuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AcuarioMapper {

    PlantaMapper INSTANCE = Mappers.getMapper(PlantaMapper.class);
    UsuarioMapper INSTANCE2 = Mappers.getMapper(UsuarioMapper.class);


    AcuarioDTO toDTO(Acuario entity);


    Acuario toEntity(AcuarioDTO dto);

}
