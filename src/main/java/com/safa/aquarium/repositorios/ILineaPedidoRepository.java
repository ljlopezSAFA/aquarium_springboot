package com.safa.aquarium.repositorios;

import com.safa.aquarium.modelos.LineaPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILineaPedidoRepository extends JpaRepository<LineaPedido, Integer> {
}
