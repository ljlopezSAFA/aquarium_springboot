package com.safa.aquarium.controladores;


import com.safa.aquarium.dto.AcuarioCrearDTO;
import com.safa.aquarium.dto.ApiResponse;
import com.safa.aquarium.modelos.Acuario;
import com.safa.aquarium.servicios.AcuarioService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acuario")
@AllArgsConstructor
public class AcuarioController {

    private AcuarioService service;


    @GetMapping("/all")
    public List<Acuario> obtenerTodosAcuarios(){
        return service.buscarTodos();
    }

    //path variable
    @GetMapping("/{id}")
    public Acuario obtenerPorId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }


    @PostMapping("/crear")
    public void crearAcuario(@Valid @RequestBody AcuarioCrearDTO dto){
        service.crearAcuario(dto);
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
