package com.safa.aquarium.conversores;

import com.safa.aquarium.dto.PlantaDTO;
import com.safa.aquarium.modelos.Planta;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlantaMapper {

    Planta toEntity(PlantaDTO dto);

    PlantaDTO toDTO(Planta entity);
}
