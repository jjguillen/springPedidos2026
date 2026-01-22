package com.jaroso.pedidos2026.dtos;

import java.util.List;

public record ClienteDto(Long id, String nombre, String email, List<PedidoResumenDto> pedidos) {
}
