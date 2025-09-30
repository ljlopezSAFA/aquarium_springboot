package com.safa.aquarium.servicios;


import com.safa.aquarium.modelos.Usuario;
import com.safa.aquarium.repositorios.IUsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsuarioService {

    private IUsuarioRepository repository;

    public Usuario getById(Integer id){
        return repository.findById(id).orElse(null);
    }

}
