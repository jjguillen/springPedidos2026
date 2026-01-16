package com.jaroso.pedidos2026.controllers;

import com.jaroso.pedidos2026.entities.Producto;
import com.jaroso.pedidos2026.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> getProducto(@PathVariable Long id) {
        Optional<Producto> producto = productoRepository.findById(id);
        if (producto.isPresent()) {
            return ResponseEntity.ok(producto.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/productos")
    public ResponseEntity<List<Producto>> getAllProductos(){
        return ResponseEntity.ok(productoRepository.findAll());
    }

    @DeleteMapping("/productos/{id}")
    public ResponseEntity<Producto> deleteProducto(@PathVariable Long id) {
        Optional<Producto> producto = productoRepository.findById(id);
        if (producto.isPresent()) {
            productoRepository.delete(producto.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/productos")
    public ResponseEntity<Producto> saveProducto(@RequestBody Producto producto){
        return ResponseEntity.status(HttpStatus.CREATED).body(productoRepository.save(producto));
    }


}
