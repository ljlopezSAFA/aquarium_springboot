package com.safa.aquarium.servicios;

import com.safa.aquarium.dto.CrearPezDTO;
import com.safa.aquarium.dto.PezDTO;
import com.safa.aquarium.modelos.Pez;
import com.safa.aquarium.repositorios.IPezRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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


    public void crearPez(CrearPezDTO dto){

        Pez pez = new Pez();
        pez.setFoto(dto.getFoto());
        pez.setNombreComun(dto.getNombre());
        pez.setDescripcion(dto.getDescripcion());
        pez.setEspecie(dto.getEspecie());
        pez.setFicha(dto.getFicha());

        repository.save(pez);

    }


    public void modificarPez(Integer id, CrearPezDTO dto){

        Optional<Pez> pez = repository.findById(id);

        if(pez.isPresent()){
            Pez pezModificar = pez.get();
            pezModificar.setFoto(dto.getFoto());
            pezModificar.setNombreComun(dto.getNombre());
            pezModificar.setDescripcion(dto.getDescripcion());
            pezModificar.setEspecie(dto.getEspecie());
            pezModificar.setFicha(dto.getFicha());
            repository.save(pezModificar);
        }




    }


    public void borrar(Integer id){
        repository.deleteById(id);
    }

}
