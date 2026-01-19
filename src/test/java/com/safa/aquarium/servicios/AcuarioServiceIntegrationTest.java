package com.safa.aquarium.servicios;


import com.safa.aquarium.conversores.AcuarioMapper;
import com.safa.aquarium.dto.AcuarioDetalleDTO;
import com.safa.aquarium.dto.AcuarioPlantaVincularDTO;
import com.safa.aquarium.modelos.Acuario;
import com.safa.aquarium.modelos.Planta;
import com.safa.aquarium.repositorios.IAcuarioRepository;
import com.safa.aquarium.repositorios.IPlantaRepository;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class AcuarioServiceIntegrationTest {


    @InjectMocks
    private AcuarioService service;

    @Mock
    private IAcuarioRepository repository;

    @Mock
    private IPlantaRepository plantaRepository;

    @Mock
    private AcuarioMapper mapper;



    @Test
    @DisplayName("Test de Integración -> BuscarPorId()")
    public void buscarPorIdIntegrationTest(){

        //GIVEN
        Mockito.when(this.repository.findById(Mockito.anyInt())).thenReturn(Optional.of(new Acuario()));
        Mockito.when(this.mapper.toDetalleDTO(Mockito.any(Acuario.class))).thenReturn(new AcuarioDetalleDTO());

        //THEN
        this.service.buscarPorId(1);

        //WHEN
        Mockito.verify(this.repository).findById(Mockito.anyInt());
        Mockito.verify(this.mapper).toDetalleDTO(Mockito.any());
    }


    @Test
    @DisplayName("Test Integración -> vincular()")
    public void vincularIntegrationTest(){

        //GIVEN
        Mockito.when(this.repository.findById(Mockito.anyInt())).thenReturn(Optional.empty());
        Mockito.when(this.plantaRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(new Planta()));

        AcuarioPlantaVincularDTO dto = new AcuarioPlantaVincularDTO();
        dto.setIdAcuario(1);
        dto.setIdPlanta(1);


        //THEN
        this.service.vincular(dto);

        //WHEN
        Mockito.verify(this.repository).findById(Mockito.anyInt());
        Mockito.verify(this.plantaRepository).findById(Mockito.anyInt());
        Mockito.verify(this.repository, Mockito.never()).save(Mockito.any());

    }


    @Test
    @DisplayName("Test Integración -> vincular2()")
    public void vincularIntegrationTest2(){

        //GIVEN
        Acuario a = new Acuario();
        Planta p = new Planta();
        a.setPlantas(new HashSet<>(List.of(p)));

        Mockito.when(this.repository.findById(Mockito.anyInt())).thenReturn(Optional.of(a));
        Mockito.when(this.plantaRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(p));

        AcuarioPlantaVincularDTO dto = new AcuarioPlantaVincularDTO();
        dto.setIdAcuario(1);
        dto.setIdPlanta(1);


        //THEN
        this.service.vincular(dto);

        //WHEN
        Mockito.verify(this.repository).findById(Mockito.anyInt());
        Mockito.verify(this.plantaRepository).findById(Mockito.anyInt());
        Mockito.verify(this.repository, Mockito.never()).save(Mockito.any());

    }

















}
