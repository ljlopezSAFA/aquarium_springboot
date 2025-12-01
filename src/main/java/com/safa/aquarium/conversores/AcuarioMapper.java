package com.safa.aquarium.conversores;

import com.safa.aquarium.dto.AcuarioCrearDTO;
import com.safa.aquarium.dto.AcuarioDTO;
import com.safa.aquarium.modelos.Acuario;
import com.safa.aquarium.modelos.Usuario;
import com.safa.aquarium.repositorios.IUsuarioRepository;
import org.mapstruct.Mapper;
import java.util.List;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class AcuarioMapper {


    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Mapping(source = "idUsuario", target = "usuario")
    public abstract Acuario toEntity(AcuarioCrearDTO dto);

    public abstract AcuarioDTO toDTO(Acuario entity);

    public abstract List<AcuarioDTO> toDTO(List<Acuario> entity);

    Usuario transformasUsuario(Integer id){
        return  usuarioRepository.findById(id).orElse(null);

    }






}
