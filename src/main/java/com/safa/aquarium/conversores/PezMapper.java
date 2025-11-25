package com.safa.aquarium.conversores;


import com.safa.aquarium.dto.CrearPezDTO;
import com.safa.aquarium.dto.PezDTO;
import com.safa.aquarium.modelos.Pez;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "Spring")
public interface PezMapper {


    @Mapping(source = "nombre", target ="nombreComun")
    Pez convertirAEntity(PezDTO dto);


    List<Pez> convertirAEntity(List<PezDTO> dtos);

    @Mapping(source = "nombreComun", target ="nombre" )
    PezDTO convertirADTO(Pez entity);

    List<PezDTO> convertirADTO(List<Pez> dtos);


    @Mapping(source = "nombre", target ="nombreComun")
    Pez convertirAEntity(CrearPezDTO dto);



}
