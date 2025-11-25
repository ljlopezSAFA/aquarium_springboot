package com.safa.aquarium.servicios;

import com.safa.aquarium.conversores.TiendaMapper;
import com.safa.aquarium.dto.CrearTiendaDTO;
import com.safa.aquarium.dto.TiendaDTO;
import com.safa.aquarium.modelos.Tienda;
import com.safa.aquarium.repositorios.ITiendaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TiendaService {

    private ITiendaRepository repository;
    private TiendaMapper mapper;

    public List<TiendaDTO> getAll(){
       return mapper.toTiendaDTO(repository.findAll());
    }




    public void crearTienda(CrearTiendaDTO dto){
        repository.save(mapper.toEntity(dto));
    }


}
