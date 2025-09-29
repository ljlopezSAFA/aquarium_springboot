package com.safa.aquarium.repositorios;


import com.safa.aquarium.modelos.Pez;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPezRepository extends JpaRepository<Pez,Integer> {

}
