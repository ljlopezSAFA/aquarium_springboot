package com.safa.aquarium.servicios;


import com.safa.aquarium.dto.*;
import com.safa.aquarium.modelos.Usuario;
import com.safa.aquarium.repositorios.IUsuarioRepository;
import com.safa.aquarium.seguridad.MecanismoSeguridad;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioService implements UserDetailsService {

    private IUsuarioRepository repository;
    private AcuarioService acuarioService;
    private MecanismoSeguridad seguridad;



    public void crearUsuario(UsuarioDTO dto){
        Usuario usuario = new Usuario();
        usuario.setNombre(dto.getNombre());
        usuario.setDni(dto.getDni());
        usuario.setMail(dto.getMail());
        usuario.setTelefono(dto.getTelefono());
        usuario.setPassword(seguridad.getEncritadorClaves().encode(dto.getPassword()));
        usuario.setApellidos(dto.getApellidos());
        repository.save(usuario);

    }


    public Usuario getById(Integer id){
        return repository.findById(id).orElse(null);
    }



    public UsuarioDatosDTO getByIdCOnDatos(Integer id){
        Usuario usuario =  repository.findById(id).orElse(null);

        if(usuario!= null){
            UsuarioDatosDTO dto = new UsuarioDatosDTO();
            dto.setId(usuario.getId());
            dto.setNombre(usuario.getNombre());
            dto.setDni(usuario.getDni());
            dto.setMail(usuario.getMail());
            dto.setTelefono(usuario.getTelefono());
            dto.setApellidos(usuario.getApellidos());
            List<AcuarioDTO> acuarioDTOS = acuarioService.buscarAcuarioPorUsuario(usuario);
            dto.setAcuarios(acuarioDTOS);

            return dto;

        }else{
            return null;
        }

    }


    public List<EstadisticasUsuarioDTO> consultarUsuariosYAcuarios(){
        return repository.estadisticasUsuario();
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findTopByMailEquals(username);
    }



}
