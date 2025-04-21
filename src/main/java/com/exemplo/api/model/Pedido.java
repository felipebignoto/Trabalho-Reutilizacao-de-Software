package com.exemplo.api.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String cliente;
    private LocalDateTime dataPedido;
    private String status;
    private double valorTotal;
    
    @ManyToMany
    @JoinTable(
        name = "pedido_produto",
        joinColumns = @JoinColumn(name = "pedido_id"),
        inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private List<Produto> produtos = new ArrayList<>();

    // Construtores
    public Pedido() {
        this.dataPedido = LocalDateTime.now();
        this.status = "PENDENTE";
    }
    
    public Pedido(String cliente) {
        this();
        this.cliente = cliente;
    }

    // Métodos de negócio
    public void adicionarProduto(Produto produto) {
        this.produtos.add(produto);
        calcularValorTotal();
    }
    
    public void removerProduto(Produto produto) {
        this.produtos.remove(produto);
        calcularValorTotal();
    }
    
    public void calcularValorTotal() {
        this.valorTotal = produtos.stream()
                .mapToDouble(Produto::getPreco)
                .sum();
    }
    
    public void finalizarPedido() {
        this.status = "FINALIZADO";
    }
    
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

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
        calcularValorTotal();
    }
}
