package com.safa.aquarium.repositorios;


import com.safa.aquarium.modelos.Tienda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITiendaRepository extends JpaRepository<Tienda,Integer> {
}
