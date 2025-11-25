package com.safa.aquarium.controladores;

import com.safa.aquarium.dto.CrearPezDTO;
import com.safa.aquarium.dto.PezDTO;
import com.safa.aquarium.servicios.PezService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pez")
@AllArgsConstructor
public class PecesController {

    private PezService service;

    @GetMapping("/all")
    public List<PezDTO> obtenerPeces(){
        return service.consultarPeces();
    }

    @PostMapping("/crear")
    public void crearPez(@RequestBody CrearPezDTO dto){
        service.crearPez(dto);
    }


    @PutMapping("/modificar/{id}")
    public void modificarPez(@PathVariable Integer id,@RequestBody CrearPezDTO dto){
        service.modificarPez(id,dto);
    }

    @DeleteMapping("/borrar/{id}")
    public void borrarPez(@PathVariable Integer id){
        service.borrar(id);
    }

}
