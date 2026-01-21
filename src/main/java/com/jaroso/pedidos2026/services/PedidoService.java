package com.jaroso.pedidos2026.services;

import com.jaroso.pedidos2026.dtos.PedidoCreateDto;
import com.jaroso.pedidos2026.dtos.PedidoDto;

import java.util.List;
import java.util.Optional;

public interface PedidoService {
    public PedidoDto create(PedidoCreateDto dto);
    public Optional<PedidoDto> findById(Long id);
    public boolean delete(Long id);
    public List<PedidoDto> findAll();

}
