package com.safa.aquarium.seguridad;


import com.safa.aquarium.repositorios.IUsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@AllArgsConstructor
public class MecanismoSeguridad {


    private final IUsuarioRepository repository;

    @Bean
    public UserDetailsService userDetailsService() {
        return repository::findTopByMailEquals;
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(getEncritadorClaves());
        return authProvider;
    }



    public PasswordEncoder getEncritadorClaves(){
        return new BCryptPasswordEncoder();
    }





}
