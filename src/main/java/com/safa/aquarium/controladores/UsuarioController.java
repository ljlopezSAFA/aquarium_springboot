package com.safa.aquarium.controladores;


import com.safa.aquarium.dto.UsuarioDTO;
import com.safa.aquarium.dto.UsuarioDatosDTO;
import com.safa.aquarium.servicios.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@AllArgsConstructor
public class UsuarioController {


    private UsuarioService service;



    @PostMapping
    public void crearUsuario(@RequestBody UsuarioDTO dto){
        service.crearUsuario(dto);
    }

    @GetMapping("/{id}")
    public UsuarioDatosDTO consultarUsuario(@PathVariable Integer id){
       return  service.getByIdCOnDatos(id);
    }

}
