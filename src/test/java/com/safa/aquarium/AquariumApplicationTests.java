package com.safa.aquarium;

import com.safa.aquarium.modelos.Acuario;
import com.safa.aquarium.modelos.Especie;
import com.safa.aquarium.modelos.Pez;
import com.safa.aquarium.repositorios.IAcuarioRepository;
import com.safa.aquarium.repositorios.IPezRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class AquariumApplicationTests {

    @Autowired
    private IPezRepository pezRepository;

    @Autowired
    private IAcuarioRepository acuarioRepository;


    @Test
    void consultarTodosPeces() {

        List<Pez> peces = pezRepository.findAll();
        for(Pez pez:peces){
            System.out.println(pez.getNombreComun());
        }
    }

    @Test
    void crearPez() {

        Pez pez = new Pez();
        pez.setNombreComun("Colisa");
        pez.setDescripcion("Anabántido común");
        pez.setFicha("Sin ficha");
        pez.setEspecie(Especie.PEZ);

        pezRepository.save(pez);

    }


    @Test
    void editarPez() {

        Pez pez = pezRepository.findById(3).orElse(null);

        if(pez!=null){
            pez.setDescripcion("Caracol invertebrado común con rayas de colores");

            pezRepository.save(pez);
        }


    }



    @Test
    void eliminarPez() {

        pezRepository.deleteById(4);

    }


    @Test
    @Transactional
    void consultarAcuarios() {
        List<Acuario> acuarios = acuarioRepository.findAll();
        for (Acuario a : acuarios) {
            System.out.println(a.getPlantas().size()); // Fuerza la carga de plantas
        }
    }

}
