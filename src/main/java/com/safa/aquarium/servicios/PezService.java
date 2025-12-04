package com.safa.aquarium.servicios;

import com.safa.aquarium.conversores.PezMapper;
import com.safa.aquarium.dto.CrearPezDTO;
import com.safa.aquarium.dto.PezDTO;
import com.safa.aquarium.exception.EliminarNoExistenteException;
import com.safa.aquarium.modelos.Pez;
import com.safa.aquarium.repositorios.IPezRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PezService {

    private IPezRepository repository;
    private PezMapper mapper;




    public List<PezDTO> consultarPeces(){
        return mapper.convertirADTO(repository.findAll());
    }


    public void crearPez(CrearPezDTO dto){
        repository.save(mapper.convertirAEntity(dto));
    }


    public void modificarPez(Integer id, CrearPezDTO dto){

        Optional<Pez> pez = repository.findById(id);
        if(pez.isPresent()){
            Pez pezModificar = pez.get();
            pezModificar.setFoto(dto.getFoto());
            pezModificar.setNombreComun(dto.getNombreComun());
            pezModificar.setDescripcion(dto.getDescripcion());
            pezModificar.setEspecie(dto.getEspecie());
            pezModificar.setFicha(dto.getFicha());
            repository.save(pezModificar);
        }


    }


    public void borrar(Integer id){

        Pez pez = repository.findById(id).orElse(null);

        if(pez == null){

            throw new EliminarNoExistenteException("El pez que quieres eliminar no existe");

        }else{
            repository.deleteById(id);
        }


    }

}
