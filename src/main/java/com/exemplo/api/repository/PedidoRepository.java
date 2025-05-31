package com.exemplo.api.repository;

import com.exemplo.api.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Repositório para acesso aos dados de Pedido
 * Interface que herda funcionalidades básicas de CRUD do JpaRepository,
 * tornando-a um componente reutilizável para persistência de dados.
 * 
 * Este repositório pode ser estendido para incluir consultas personalizadas
 * relacionadas a pedidos, como:
 * - Busca por período
 * - Busca por cliente
 * - Busca por status
 * - Agregações e relatórios
 */
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    
}
