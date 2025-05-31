package com.exemplo.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.exemplo.api.model.Produto;
import com.exemplo.api.repository.ProdutoRepository;

/**
 * Serviço para gerenciamento de produtos
 * Camada responsável pela lógica de negócios relacionada a produtos
 * Este serviço é um componente reutilizável que encapsula as regras de negócio
 * e pode ser injetado em diferentes partes da aplicação
 */
@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    /**
     * Lista todos os produtos cadastrados
     * @return lista de todos os produtos
     */
    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    /**
     * Salva um novo produto ou atualiza um existente
     * @param produto o produto a ser salvo
     * @return o produto salvo com ID gerado
     */
    public Produto salvar(Produto produto) {
        return repository.save(produto);
    }

    /**
     * Remove um produto pelo ID
     * @param id ID do produto a ser removido
     */
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}