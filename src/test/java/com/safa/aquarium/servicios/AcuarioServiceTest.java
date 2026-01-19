package com.safa.aquarium.servicios;

import com.safa.aquarium.dto.AcuarioDetalleDTO;
import com.safa.aquarium.dto.AcuarioPlantaVincularDTO;
import com.safa.aquarium.exception.ElementoNoEncontradoException;
import com.safa.aquarium.modelos.Acuario;
import com.safa.aquarium.modelos.Planta;
import com.safa.aquarium.modelos.TipoPlanta;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
@Transactional
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AcuarioServiceTest {

    @Autowired
    private AcuarioService service;

    @Autowired
    private EntityManager entityManager;


    @BeforeAll
    void cargarDatos(){

        Acuario a = new Acuario();
        a.setNombre("Acuario de Prueba");
        a.setFoto("Foto prueba");
        a.setDescripcion("Este es el acuario de prueba");
        a.setMedidas("15*50+70");
        a.setCapacidad(60.0);
        a.setPeces(new HashSet<>());
        a.setPlantas(new HashSet<>());

        Acuario a2 = new Acuario();
        a2.setNombre("Acuario de Prueba 2");
        a2.setFoto("Foto prueba 2");
        a2.setDescripcion("Este es el acuario de prueba 2");
        a2.setMedidas("60*50*70");
        a2.setCapacidad(80.0);
        a2.setPeces(new HashSet<>());
        a2.setPlantas(new HashSet<>());


        Planta planta = new Planta();
        planta.setNombre("Planta Prueba");
        planta.setTipoPlanta(TipoPlanta.FONDO);
        planta.setFicha("Planta de prueba con su ficha");

        entityManager.persist(a);
        entityManager.persist(a2);
        entityManager.persist(planta);

    }



    @Test
    @DisplayName("Servicio 1 -> Casa Positivo")
    public void buscarPorIdTest(){
        //Given
        //PREVIOS

        //Then
        //EJECUCIÓN PRUEBA DEL MÉTODO
        AcuarioDetalleDTO dto = service.buscarPorId(1);



        //When
        //COMPROBACIONES
        assertNotNull(dto,"El acuario que se ha intentado buscar no existe o es nulo");
        assertEquals(dto.getNombre(), "Acuario de Prueba", "El nombre del acuario no coincide con el buscado");

    }


    @Test
    @DisplayName("Servicio 1 -> Casa Negavito")
    public void buscarPorIdNegativoTest(){

        //Given

        //Then

        //When
        assertThrows(ElementoNoEncontradoException.class,()-> service.buscarPorId(3));

    }


    @Test
    @DisplayName("Servicio 2 -> Casa Positivo")
    public void vincularPlantaTest(){

        //Given
        AcuarioPlantaVincularDTO dto = new AcuarioPlantaVincularDTO();
        dto.setIdAcuario(1);
        dto.setIdPlanta(1);

        //Then
        service.vincular(dto);

        //When
        AcuarioDetalleDTO acuario = service.buscarPorId(1);
        assertFalse(acuario.getPlantas().isEmpty(), "No se ha asociado la planta al acuario");


    }


}
