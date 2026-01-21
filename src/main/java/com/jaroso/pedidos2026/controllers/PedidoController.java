package com.jaroso.pedidos2026.controllers;

import com.jaroso.pedidos2026.dtos.PedidoCreateDto;
import com.jaroso.pedidos2026.dtos.PedidoDto;
import com.jaroso.pedidos2026.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<PedidoDto> savePedido(@RequestBody PedidoCreateDto pedido){
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.create(pedido));
    }

    @GetMapping
    public ResponseEntity<List<PedidoDto>> findAll(){
        return ResponseEntity.ok(pedidoService.findAll());
    }

}
