package com.safa.aquarium.seguridad;

import com.safa.aquarium.dto.LoginDTO;
import com.safa.aquarium.modelos.Usuario;
import com.safa.aquarium.repositorios.IUsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginService {

    private IUsuarioRepository repository;
    private JWTService jwtService;
    private MecanismoSeguridad seguridad;


    public String loguearUsuario(LoginDTO dto){
        Usuario usuario = repository.findTopByMailEquals(dto.getMail());

        if(usuario != null && seguridad.getEncritadorClaves().matches(dto.getPassword(), usuario.getPassword())){

            return jwtService.generateToken(usuario);

        }

        return "Fallo de autentificación";

    }

}
