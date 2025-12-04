package com.safa.aquarium.conversores;

import com.safa.aquarium.dto.PlantaDTO;
import com.safa.aquarium.modelos.Planta;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PlantaMapper {

    Planta toEntity(PlantaDTO dto);

    PlantaDTO toDTO(Planta entity);

    List<Planta> toEntity(List<PlantaDTO> dtos);

    List<PlantaDTO> toDTO(List<Planta> entities);


}
