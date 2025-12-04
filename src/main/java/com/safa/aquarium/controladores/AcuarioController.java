package com.safa.aquarium.controladores;


import com.safa.aquarium.dto.*;
import com.safa.aquarium.modelos.Acuario;
import com.safa.aquarium.servicios.AcuarioService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acuario")
@AllArgsConstructor
public class AcuarioController {

    private AcuarioService service;


    @GetMapping("/all")
    public List<AcuarioDTO> obtenerTodosAcuarios(){
        return service.buscarTodos();
    }


    @GetMapping("/detalle/{id}")
    public AcuarioDetalleDTO obtenerPorId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }


    @PostMapping("/crear")
    public void crearAcuario(@Valid @RequestBody AcuarioCrearDTO dto){
        service.crearAcuario(dto);
    }


    @PutMapping("/planta/vincular")
    public void vincularPlanta(@Valid @RequestBody AcuarioPlantaVincularDTO dto){
        service.vincular(dto);
    }

    @PutMapping("/planta/desvincular")
    public void desvincularPlanta(@Valid @RequestBody AcuarioPlantaVincularDTO dto){
       //TODO
    }


    @PutMapping("/pez/vincular")
    public void vincularPez(@Valid @RequestBody AcuarioPezVincularDTO dto){
        service.vincularPez(dto);
    }

    @PutMapping("/pez/desvincular")
    public void desvincularPez(@Valid @RequestBody AcuarioPezVincularDTO dto){
        //TODO
    }



    @PutMapping("/editar/{id}")
    public void editarAcuario(@PathVariable  Integer id,@RequestBody AcuarioCrearDTO dto){
        service.editarAcuario(id,dto);

    }

    @DeleteMapping("/{id}")
    public void eliminarAcuario(@PathVariable  Integer id){
         service.eliminarPorId(id);
    }




}
