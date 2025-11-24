package com.safa.aquarium.controladores;

import com.safa.aquarium.dto.PezDTO;
import com.safa.aquarium.servicios.PezService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

}
