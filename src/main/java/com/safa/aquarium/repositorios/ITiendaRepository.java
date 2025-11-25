package com.safa.aquarium.repositorios;


import com.safa.aquarium.dto.TiendasPorCiudad;
import com.safa.aquarium.modelos.Tienda;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ITiendaRepository extends JpaRepository<Tienda,Integer> {


    @Query(value ="select t from tienda t where ciudad = :ciudad", nativeQuery = true)
    List<Tienda> buscarPorCiudad(@Param("ciudad") String nombreCiudad);


    @Query(value ="select ciudad as nombreCiudad , count(t.id) as numTiendas from tienda t group by ciudad ",
            nativeQuery = true)
    List<TiendasPorCiudad> tiendasPorCiudad();



    @Query("select t from Tienda t where t.ciudad = :ciudad")
    List<Tienda> buscarPorCiudadJPQL(@Param("ciudad") String nombreCiudad);



    List<Tienda> findAllByCiudadEqualsAndCodigoPostalEquals(String ciudad, Integer codigoPostal);




}
