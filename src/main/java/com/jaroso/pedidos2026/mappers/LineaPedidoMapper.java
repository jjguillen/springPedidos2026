package com.jaroso.pedidos2026.mappers;

import com.jaroso.pedidos2026.dtos.LineaPedidoCreateDto;
import com.jaroso.pedidos2026.dtos.LineaPedidoDto;
import com.jaroso.pedidos2026.dtos.ProductoBasicoDto;
import com.jaroso.pedidos2026.entities.LineaPedido;
import com.jaroso.pedidos2026.entities.Producto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ProductoMapper.class})
public interface LineaPedidoMapper {

    @Mapping(target = "subtotal", expression = "java(java.math.BigDecimal.valueOf(lineaPedido.getCantidad() " +
            "* lineaPedido.getProducto().getPrecio()))")
    LineaPedidoDto toDto(LineaPedido lineaPedido);

    LineaPedido lineaPedidoCreateDtoEntity(LineaPedidoCreateDto dto);


}
