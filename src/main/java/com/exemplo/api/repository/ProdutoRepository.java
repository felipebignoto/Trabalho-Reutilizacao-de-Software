package com.exemplo.api.repository;

import com.exemplo.api.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório para acesso aos dados de Produto
 * Interface que herda funcionalidades básicas de CRUD do JpaRepository,
 * tornando-a um componente reutilizável para persistência de dados.
 * 
 * Por estender JpaRepository, já fornece os seguintes métodos:
 * - save(): salvar/atualizar produto
 * - findById(): buscar produto por ID
 * - findAll(): listar todos os produtos
 * - delete(): remover produto
 * - entre outros
 */
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}