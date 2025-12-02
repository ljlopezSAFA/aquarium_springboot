package com.safa.aquarium.controladores;


import com.safa.aquarium.dto.EstadisticasUsuarioDTO;
import com.safa.aquarium.dto.LoginDTO;
import com.safa.aquarium.dto.UsuarioDTO;
import com.safa.aquarium.dto.UsuarioDatosDTO;
import com.safa.aquarium.seguridad.LoginService;
import com.safa.aquarium.servicios.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
@AllArgsConstructor
public class UsuarioController {


    private UsuarioService service;
    private LoginService loginService;



    @PostMapping("/login")
    public String login(@RequestBody LoginDTO dto){
       return  loginService.loguearUsuario(dto);
    }

    @PostMapping("/crear")
    public void crearUsuario(@RequestBody UsuarioDTO dto){
        service.crearUsuario(dto);
    }

    @GetMapping("/{id}")
    public UsuarioDatosDTO consultarUsuario(@PathVariable Integer id){
       return  service.getByIdCOnDatos(id);
    }


    @GetMapping("/estadisticas")
    public List<EstadisticasUsuarioDTO> estadisticas(){
        return  service.consultarUsuariosYAcuarios();
    }

}
