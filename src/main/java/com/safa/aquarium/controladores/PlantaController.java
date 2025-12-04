package com.safa.aquarium.controladores;


import com.safa.aquarium.dto.PlantaDTO;
import com.safa.aquarium.servicios.PlantaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/plantas")
@AllArgsConstructor
public class PlantaController {

    private PlantaService plantaService;


    @GetMapping("/all")
    public List<PlantaDTO> obtenerTodas(){
        return plantaService.obtenerTodas();
    }




}
