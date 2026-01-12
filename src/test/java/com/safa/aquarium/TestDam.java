package com.safa.aquarium;

import com.safa.aquarium.modelos.Tienda;
import com.safa.aquarium.repositorios.ITiendaRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
@Transactional
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestDam {

    @Autowired
    private ITiendaRepository tiendaRepository;

    @BeforeAll
    void inicializarDatos (){
        Tienda t1 = new Tienda();
        t1.setNombre("Kiwoko");
        t1.setCiudad("Sevilla");
        t1.setDireccion("Calle Calatrava");
        t1.setCodigoPostal(41002);
        t1.setUrlLogo("url.prueba.es");

        tiendaRepository.save(t1);

    }



    @Test
    void consultarTiendas() {

        List<Tienda> tiendas = tiendaRepository.findAll();

        assertEquals(1,tiendas.size(), "El resultado obtenido no es el esperado");



    }
}
