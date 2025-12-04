package com.safa.aquarium.conversores;


import com.safa.aquarium.dto.CrearPezDTO;
import com.safa.aquarium.dto.PezDTO;
import com.safa.aquarium.modelos.Pez;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "Spring")
public interface PezMapper {



    Pez convertirAEntity(PezDTO dto);


    List<Pez> convertirAEntity(List<PezDTO> dtos);


    PezDTO convertirADTO(Pez entity);

    List<PezDTO> convertirADTO(List<Pez> dtos);


    Pez convertirAEntity(CrearPezDTO dto);



}
