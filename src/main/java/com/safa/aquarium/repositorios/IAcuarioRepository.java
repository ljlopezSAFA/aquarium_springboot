package com.safa.aquarium.repositorios;

import com.safa.aquarium.dto.PersonajesPorPlaneta;
import com.safa.aquarium.modelos.Acuario;
import com.safa.aquarium.modelos.Usuario;
import org.apache.logging.log4j.spi.ObjectThreadContextMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAcuarioRepository extends JpaRepository<Acuario,Integer> {


    @Query( value = "select a from acuario a where capacidad > :capacidad and medidas = :medidas",nativeQuery = true)
    List<Acuario> buscarConCapacidadSuperior(@Param("capacidad") Double capacidadMinima, @Param("medidas") String medidasDeseadas);


    @Query(value = "select p2.nombre , count(p.id) from personaje p \n" +
            "join planeta p2 on p2.id  = p.id_planeta \n" +
            "group by p.id_planeta " , nativeQuery = true)
    List<PersonajesPorPlaneta> buscarPersonajesPorPlaneta();




    @Query("select a from Acuario a where a.capacidad > :capacidadMinima and a.medidas = :medidasReferencia")
    List<Acuario> buscarConCapacidadSuperiorJPQL();


    @Query("select count(a) from Acuario a where a.usuario.mail = :emailReferencia")
    Integer  buscarAcuariosUsuarioEmail(@Param("emailReferencia") String email);



    List<Acuario> findAllByCapacidadIsGreaterThanAndMedidasEquals(Double capacidad,String medidas);




    List<Acuario> findAllByUsuarioEquals(Usuario usuario);


}
