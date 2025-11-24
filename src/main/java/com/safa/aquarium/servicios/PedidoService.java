package com.safa.aquarium.servicios;


import com.safa.aquarium.dto.PedidoDTO;
import com.safa.aquarium.dto.ProductoDTO;
import com.safa.aquarium.modelos.LineaPedido;
import com.safa.aquarium.modelos.Pedido;
import com.safa.aquarium.repositorios.IPedidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PedidoService {


    private IPedidoRepository pedidoRepository;


    public List<PedidoDTO> obtenerTodosPedidos(){

        List<Pedido> pedidos = pedidoRepository.findAll();
        List<PedidoDTO> dtos = new ArrayList<>();

        for(Pedido p : pedidos){

            PedidoDTO dto = new PedidoDTO();
            dto.setCodigoPedido(p.getCodigo());
            dto.setFechaPedido(p.getFecha().toString());


            List<ProductoDTO> productos = new ArrayList<>();

            for(LineaPedido l: p.getLineas()){
                ProductoDTO pdto = new ProductoDTO();
                pdto.setNombre(l.getProducto().getNombre());
                productos.add(pdto);

            }

            dto.setProductos(productos);

            dtos.add(dto);


        }
        return dtos;
    }


}
