package com.safa.aquarium.servicios;


import com.safa.aquarium.conversores.PlantaMapper;
import com.safa.aquarium.dto.PlantaDTO;
import com.safa.aquarium.repositorios.IPlantaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class PlantaService {

    private IPlantaRepository repository;
    private PlantaMapper mapper;


    public List<PlantaDTO> obtenerTodas(){
        return mapper.toDTO(repository.findAll());
    }




}
