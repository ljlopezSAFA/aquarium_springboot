package com.safa.aquarium.repositorios;


import com.safa.aquarium.dto.EstadisticasUsuarioDTO;
import com.safa.aquarium.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario,Integer> {


    @Query(value = "select u.id as usuario, u.nombre as nombre_usuario, \n" +
            "count(a.id) as numero_acuarios\n" +
            "from aquarium.usuario u\n" +
            "left join aquarium.acuario a on a.id_usuario = u.id\n" +
            "group by a.id_usuario , u.nombre , u.apellidos  , u.id \n" +
            "order by numero_acuarios desc limit 5",nativeQuery = true)
     List<EstadisticasUsuarioDTO> estadisticasUsuario();


}
