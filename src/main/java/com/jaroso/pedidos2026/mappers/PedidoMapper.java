package com.jaroso.pedidos2026.mappers;

import com.jaroso.pedidos2026.dtos.LineaPedidoDto;
import com.jaroso.pedidos2026.dtos.PedidoCreateDto;
import com.jaroso.pedidos2026.dtos.PedidoDto;
import com.jaroso.pedidos2026.entities.LineaPedido;
import com.jaroso.pedidos2026.entities.Pedido;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PedidoMapper {
    PedidoDto toDto(Pedido pedido);
    Pedido pedidoCreateDtoToEntity(PedidoCreateDto dto);
    List<LineaPedidoDto> lineasToDto(List<LineaPedido> lineas);
}
