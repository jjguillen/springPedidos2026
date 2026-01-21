package com.jaroso.pedidos2026.repositories;

import com.jaroso.pedidos2026.entities.LineaPedido;
import com.jaroso.pedidos2026.entities.Pedido;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LineaPedidoRepository extends JpaRepository<LineaPedido, Long> {
}
