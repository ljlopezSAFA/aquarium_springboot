package com.safa.aquarium.controladores;


import com.safa.aquarium.dto.PedidoDTO;
import com.safa.aquarium.modelos.Pedido;
import com.safa.aquarium.servicios.PedidoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
@AllArgsConstructor
public class PedidoController {

    private PedidoService service;

    @GetMapping("/all")
    public List<PedidoDTO> buscarTodos(){
        return service.obtenerTodosPedidos();
    }


}
