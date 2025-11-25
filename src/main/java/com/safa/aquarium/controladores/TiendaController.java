package com.safa.aquarium.controladores;

import com.safa.aquarium.dto.CrearTiendaDTO;
import com.safa.aquarium.dto.TiendaDTO;
import com.safa.aquarium.servicios.TiendaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tiendas")
@AllArgsConstructor
public class TiendaController {

    private TiendaService service;

    @GetMapping("/all")
    public List<TiendaDTO> buscarTodas(){
        return service.getAll();
    }

    @PostMapping("/crear")
    public void crearTienda(@RequestBody  CrearTiendaDTO dto){
        service.crearTienda(dto);

    }

}
