package com.safa.aquarium.repositorios;

import com.safa.aquarium.modelos.Planta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlantaRepository extends JpaRepository<Planta,Integer> {
}
