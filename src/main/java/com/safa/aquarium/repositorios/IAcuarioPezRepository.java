package com.safa.aquarium.repositorios;

import com.safa.aquarium.modelos.Acuario;
import com.safa.aquarium.modelos.AcuarioPez;
import com.safa.aquarium.modelos.Pez;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAcuarioPezRepository  extends JpaRepository<AcuarioPez, Integer> {


    AcuarioPez findFirstByPezEqualsAndAcuarioEquals(Pez pez, Acuario acuario);

}
