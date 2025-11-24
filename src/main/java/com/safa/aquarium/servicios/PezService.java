package com.safa.aquarium.servicios;

import com.safa.aquarium.dto.PezDTO;
import com.safa.aquarium.modelos.Pez;
import com.safa.aquarium.repositorios.IPezRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class PezService {

    private IPezRepository repository;




    public List<PezDTO> consultarPeces(){

        List<Pez> peces = repository.findAll();
        List<PezDTO> dtos = new ArrayList<>();

        for(Pez p: peces){
            PezDTO dto = new PezDTO();
            dto.setId(p.getId());
            dto.setNombre(p.getNombreComun());
            dto.setFoto(p.getFoto());
            dto.setDescripcion(p.getDescripcion());
            dtos.add(dto);
        }

        return dtos;
    }

}
