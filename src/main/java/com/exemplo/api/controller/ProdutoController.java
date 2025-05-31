package com.exemplo.api.controller;

import com.exemplo.api.common.ApiResponse;
import com.exemplo.api.common.IdValidator;
import com.exemplo.api.model.Produto;
import com.exemplo.api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller para gerenciamento de produtos
 * Utiliza componentes reutilizáveis para validação e respostas padronizadas
 */
@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public ApiResponse<List<Produto>> listarProdutos() {
        return ApiResponse.success(produtoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ApiResponse<Produto> buscarProduto(@PathVariable Long id) {
        Produto produto = IdValidator.validateResource(id, produtoRepository, "Produto");
        return ApiResponse.success(produto);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<Produto> criarProduto(@RequestBody Produto produto) {
        return ApiResponse.success(produtoRepository.save(produto));
    }

    @PutMapping("/{id}")
    public ApiResponse<Produto> atualizarProduto(@PathVariable Long id, @RequestBody Produto produtoAtualizado) {
        IdValidator.validateResource(id, produtoRepository, "Produto");
        produtoAtualizado.setId(id);
        return ApiResponse.success(produtoRepository.save(produtoAtualizado));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ApiResponse<Void> deletarProduto(@PathVariable Long id) {
        IdValidator.validateResource(id, produtoRepository, "Produto");
        produtoRepository.deleteById(id);
        return ApiResponse.success(null);
    }
}