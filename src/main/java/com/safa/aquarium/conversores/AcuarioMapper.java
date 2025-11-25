package com.safa.aquarium.conversores;

import com.safa.aquarium.dto.AcuarioCrearDTO;
import com.safa.aquarium.modelos.Acuario;
import com.safa.aquarium.modelos.Usuario;
import com.safa.aquarium.repositorios.IUsuarioRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class AcuarioMapper {


    @Autowired
    private IUsuarioRepository usuarioRepository;


    @Mapping(source = "idUsuario", target = "usuario")
    public abstract Acuario toEntity(AcuarioCrearDTO dto);

    Usuario transformasUsuario(Integer id){
        return  usuarioRepository.findById(id).orElse(null);

    }






}
