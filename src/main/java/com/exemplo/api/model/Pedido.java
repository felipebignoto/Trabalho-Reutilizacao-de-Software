package com.exemplo.api.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Entidade que representa um pedido no sistema.
 * Esta classe é um componente reutilizável que implementa o conceito de pedido,
 * podendo ser utilizada em diferentes contextos como vendas, compras, orçamentos, etc.
 * 
 * Características principais:
 * - Gerenciamento automático de data e hora
 * - Cálculo automático do valor total
 * - Controle de status do pedido
 * - Relacionamento Many-to-Many com produtos
 */
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * Nome ou identificador do cliente que fez o pedido
     */
    private String cliente;

    /**
     * Data e hora em que o pedido foi criado
     */
    private LocalDateTime dataPedido;

    /**
     * Status atual do pedido (PENDENTE, FINALIZADO, CANCELADO)
     */
    private String status;

    /**
     * Valor total do pedido, calculado automaticamente com base nos produtos
     */
    private double valorTotal;
    
    /**
     * Lista de produtos incluídos no pedido
     * Utiliza relacionamento Many-to-Many com tabela de junção
     */
    @ManyToMany
    @JoinTable(
        name = "pedido_produto",
        joinColumns = @JoinColumn(name = "pedido_id"),
        inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private List<Produto> produtos = new ArrayList<>();

    /**
     * Construtor padrão que inicializa o pedido com status PENDENTE
     * e data atual
     */
    public Pedido() {
        this.dataPedido = LocalDateTime.now();
        this.status = "PENDENTE";
    }
    
    /**
     * Construtor que permite definir o cliente no momento da criação
     * @param cliente nome ou identificador do cliente
     */
    public Pedido(String cliente) {
        this();
        this.cliente = cliente;
    }

    /**
     * Adiciona um produto ao pedido e recalcula o valor total
     * @param produto produto a ser adicionado
     */
    public void adicionarProduto(Produto produto) {
        this.produtos.add(produto);
        calcularValorTotal();
    }
    
    /**
     * Remove um produto do pedido e recalcula o valor total
     * @param produto produto a ser removido
     */
    public void removerProduto(Produto produto) {
        this.produtos.remove(produto);
        calcularValorTotal();
    }
    
    /**
     * Calcula o valor total do pedido somando os preços dos produtos
     */
    public void calcularValorTotal() {
        this.valorTotal = produtos.stream()
                .mapToDouble(Produto::getPreco)
                .sum();
    }
    
    /**
     * Altera o status do pedido para FINALIZADO
     */
    public void finalizarPedido() {
        this.status = "FINALIZADO";
    }
    
    /**
     * Altera o status do pedido para CANCELADO
     */
    public void cancelarPedido() {
        this.status = "CANCELADO";
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDateTime dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    /**
     * Define a lista de produtos e recalcula o valor total do pedido
     * @param produtos nova lista de produtos
     */
    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
        calcularValorTotal();
    }
}
