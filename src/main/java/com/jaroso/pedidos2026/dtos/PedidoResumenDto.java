package com.jaroso.pedidos2026.dtos;

import com.jaroso.pedidos2026.entities.EstadoPedido;

import java.time.LocalDate;

public record PedidoResumenDto(Long id, EstadoPedido estado, LocalDate fecha) {
}
