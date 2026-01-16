package com.jaroso.pedidos2026.repositories;

import com.jaroso.pedidos2026.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
