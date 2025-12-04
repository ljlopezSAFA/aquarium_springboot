package com.safa.aquarium.conversores;


import com.safa.aquarium.dto.AcuarioPezDTO;
import com.safa.aquarium.modelos.AcuarioPez;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface AcuarioPezMapper {


   AcuarioPez toEntity(AcuarioPezDTO dto);


   AcuarioPezDTO toDTO(AcuarioPez entity);



}
