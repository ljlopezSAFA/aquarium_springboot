package com.safa.aquarium.servicios;


import com.safa.aquarium.conversores.AcuarioMapper;
import com.safa.aquarium.dto.*;
import com.safa.aquarium.exception.ElementoNoEncontradoException;
import com.safa.aquarium.modelos.*;
import com.safa.aquarium.repositorios.IAcuarioPezRepository;
import com.safa.aquarium.repositorios.IAcuarioRepository;
import com.safa.aquarium.repositorios.IPezRepository;
import com.safa.aquarium.repositorios.IPlantaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class AcuarioService {

    private IAcuarioRepository repository;
    private IPlantaRepository plantaRepository;
    private IPezRepository pezRepository;
    private IAcuarioPezRepository acuarioPezRepository;
    private AcuarioMapper mapper;


    public List<AcuarioDTO> buscarTodos(){
        return mapper.toDTO(repository.findAll());
    }


    public List<AcuarioDTO> buscarAcuarioPorUsuario(Usuario usuario){
        return mapper.toDTO(repository.findAllByUsuarioEquals(usuario));
    }


    public AcuarioDetalleDTO buscarPorId(Integer id){
        Acuario acuario = repository.findById(id).orElse(null);

        if(acuario== null){
            throw  new ElementoNoEncontradoException("No se ha encontrado el acuario con el id indicado");
        }

        return mapper.toDetalleDTO(acuario);
    }

    public void crearAcuario(AcuarioCrearDTO dto){
        repository.save(mapper.toEntity(dto));
    }



    public void vincular(AcuarioPlantaVincularDTO dto){

        Acuario acuario = repository.findById(dto.getIdAcuario()).orElse(null);
        Planta planta =  plantaRepository.findById(dto.getIdPlanta()).orElse(null);

        if(acuario!= null && planta!= null & !acuario.getPlantas().contains(planta)){

            acuario.getPlantas().add(planta);
            repository.save(acuario);
        }
    }



    public void vincularPez(AcuarioPezVincularDTO dto){
        Acuario acuario = repository.findById(dto.getIdAcuario()).orElse(null);
        Pez pez =  pezRepository.findById(dto.getIdPez()).orElse(null);



        if(acuario!= null && pez!= null){
            AcuarioPez acuarioPez = acuarioPezRepository.findFirstByPezEqualsAndAcuarioEquals(pez,acuario);

            if(acuarioPez!=null){
                acuarioPez.setCantidad(dto.getCantidad());
                acuarioPez.setCantidadHembra(dto.getCantidadHembra());
                acuarioPez.setCantidadMacho(dto.getCantidadMacho());

                acuarioPezRepository.save(acuarioPez);

            }else{
                AcuarioPez nuevo = new AcuarioPez();
                nuevo.setPez(pez);
                nuevo.setAcuario(acuario);
                nuevo.setCantidad(dto.getCantidad());
                nuevo.setCantidadMacho(dto.getCantidadMacho());
                nuevo.setCantidadHembra(dto.getCantidadHembra());
                acuarioPezRepository.save(nuevo);
            }

        }

    }


    public void editarAcuario(Integer id, AcuarioCrearDTO dto){
        Acuario acuarioNuevo = repository.findById(id).orElse(null);


        if(acuarioNuevo != null){
            acuarioNuevo.setCapacidad(dto.getCapacidad());
            acuarioNuevo.setMedidas(dto.getMedidas());
            acuarioNuevo.setNombre(dto.getNombre());
            acuarioNuevo.setDescripcion(dto.getDescripcion());
            acuarioNuevo.setFoto(dto.getFoto());
            repository.save(acuarioNuevo);
        }

    }


    public void eliminarPorId(Integer id){
        repository.deleteById(id);
    }










}
