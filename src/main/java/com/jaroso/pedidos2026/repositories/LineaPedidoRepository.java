package com.jaroso.pedidos2026.repositories;

import com.jaroso.pedidos2026.entities.LineaPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineaPedidoRepository extends JpaRepository<LineaPedido, Long> {
}
