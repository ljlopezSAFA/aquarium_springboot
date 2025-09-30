package com.safa.aquarium;

import com.safa.aquarium.modelos.Pez;
import com.safa.aquarium.modelos.Tienda;
import com.safa.aquarium.repositorios.ITiendaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestDam {

    @Autowired
    private ITiendaRepository tiendaRepository;



    @Test
    void consultarTiendas() {

        List<Tienda> tiendas = tiendaRepository.findAll();

        for(Tienda t: tiendas){
            System.out.println(t.getNombre());
        }


    }
}
