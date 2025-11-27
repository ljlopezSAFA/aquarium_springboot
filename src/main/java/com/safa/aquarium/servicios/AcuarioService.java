package com.safa.aquarium.servicios;


import com.safa.aquarium.conversores.AcuarioMapper;
import com.safa.aquarium.dto.AcuarioCrearDTO;
import com.safa.aquarium.dto.AcuarioDTO;
import com.safa.aquarium.modelos.Acuario;
import com.safa.aquarium.modelos.Usuario;
import com.safa.aquarium.repositorios.IAcuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AcuarioService {

    private IAcuarioRepository repository;
    private AcuarioMapper mapper;


    public List<AcuarioDTO> buscarTodos(){
        return mapper.toDTO(repository.findAll());
    }


    public List<AcuarioDTO> buscarAcuarioPorUsuario(Usuario usuario){
        return mapper.toDTO(repository.findAllByUsuarioEquals(usuario));
    }


    public Acuario buscarPorId(Integer id){
        Acuario acuario = repository.findById(id).orElse(null);
        return acuario;
    }

    public void crearAcuario(AcuarioCrearDTO dto){
        repository.save(mapper.toEntity(dto));
    }


    public void editarAcuario(Integer id, AcuarioCrearDTO dto){
        Acuario acuarioNuevo = repository.findById(id).orElse(null);

        if(acuarioNuevo != null){
            acuarioNuevo.setCapacidad(dto.getCapacidad());
            acuarioNuevo.setMedidas(dto.getMedidas());

            repository.save(acuarioNuevo);
        }

    }


    public void eliminarPorId(Integer id){
        repository.deleteById(id);
    }










}
