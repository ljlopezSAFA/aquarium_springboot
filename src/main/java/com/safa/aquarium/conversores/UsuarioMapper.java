package com.safa.aquarium.conversores;

import com.safa.aquarium.dto.UsuarioDTO;
import com.safa.aquarium.modelos.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario toEntity(UsuarioDTO dto);

    UsuarioDTO toDTO(Usuario usuario);

}
