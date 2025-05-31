package com.exemplo.api.controller;

import com.exemplo.api.common.ApiResponse;
import com.exemplo.api.common.IdValidator;
import com.exemplo.api.model.Pedido;
import com.exemplo.api.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller para gerenciamento de pedidos
 * Utiliza componentes reutilizáveis para validação e respostas padronizadas
 */
@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping
    public ApiResponse<List<Pedido>> listarTodos() {
        return ApiResponse.success(pedidoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ApiResponse<Pedido> buscarPedido(@PathVariable Long id) {
        Pedido pedido = IdValidator.validateResource(id, pedidoRepository, "Pedido");
        return ApiResponse.success(pedido);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<Pedido> criarPedido(@RequestBody Pedido pedido) {
        return ApiResponse.success(pedidoRepository.save(pedido));
    }

    @PutMapping("/{id}")
    public ApiResponse<Pedido> atualizarPedido(@PathVariable Long id, @RequestBody Pedido pedidoAtualizado) {
        IdValidator.validateResource(id, pedidoRepository, "Pedido");
        pedidoAtualizado.setId(id);
        return ApiResponse.success(pedidoRepository.save(pedidoAtualizado));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ApiResponse<Void> deletarPedido(@PathVariable Long id) {
        IdValidator.validateResource(id, pedidoRepository, "Pedido");
        pedidoRepository.deleteById(id);
        return ApiResponse.success(null);
    }
}
