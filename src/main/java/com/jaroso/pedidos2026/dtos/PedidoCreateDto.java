package com.jaroso.pedidos2026.dtos;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public record PedidoCreateDto(Long clienteId, List<LineaPedidoCreateDto> lineas) {

}
