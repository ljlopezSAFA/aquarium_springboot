package com.safa.aquarium.seguridad;


import com.safa.aquarium.modelos.Usuario;
import com.safa.aquarium.servicios.UsuarioService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@AllArgsConstructor
public class JWTFilter extends OncePerRequestFilter {



    private JWTService jwtService;
    private UsuarioService usuarioService;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {


        final String authHeader = request.getHeader("Authorization");


        //Si viene por una url "/auth" lo dejamos pasar
        if (request.getServletPath().contains("/usuarios")){
            filterChain.doFilter(request, response);
            return;
        }

        if(authHeader== null || !authHeader.startsWith("Bearer")){
            filterChain.doFilter(request,response);
            return;
        }


        String token = authHeader.substring(7);
        JWTDatosDTO datos = jwtService.extractTokenData(token);


        if(datos!=null && SecurityContextHolder.getContext().getAuthentication() == null && !jwtService.isExpired(token)){


            Usuario usuario = (Usuario) usuarioService.loadUserByUsername(datos.getMailUsuario());


            if(usuario!= null){
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        usuario.getUsername(),
                        usuario.getPassword(),
                        usuario.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }

        }

        filterChain.doFilter(request, response);





    }
}
