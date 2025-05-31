package com.exemplo.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Entidade que representa um produto no sistema.
 * Esta classe é um componente reutilizável que pode ser usado em diferentes contextos,
 * como catálogo de produtos, pedidos, estoque, etc.
 */
@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nome do produto
     */
    private String nome;

    /**
     * Preço unitário do produto
     */
    private double preco;

    // Getters e Setters
    /**
     * @return o ID único do produto
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id o ID a ser definido para o produto
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return o nome do produto
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome o nome a ser definido para o produto
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return o preço unitário do produto
     */
    public double getPreco() {
        return preco;
    }

    /**
     * @param preco o preço a ser definido para o produto
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }
}