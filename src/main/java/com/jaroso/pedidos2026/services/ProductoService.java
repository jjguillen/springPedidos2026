package com.jaroso.pedidos2026.services;

import com.jaroso.pedidos2026.dtos.ProductoCreateDto;
import com.jaroso.pedidos2026.dtos.ProductoDto;
import java.util.List;
import java.util.Optional;

public interface ProductoService {
    public ProductoDto create(ProductoCreateDto dto);
    public List<ProductoDto> findAll();
    public Optional<ProductoDto> findById(Long id);
    public boolean delete(Long id);
}
