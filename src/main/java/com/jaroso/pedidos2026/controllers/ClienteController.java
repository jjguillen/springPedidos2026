package com.jaroso.pedidos2026.controllers;

import com.jaroso.pedidos2026.entities.Cliente;
import com.jaroso.pedidos2026.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClientes(){
        return ResponseEntity.ok(clienteRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getCliente(@PathVariable Long id){
        return clienteRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Cliente> saveCliente(@RequestBody Cliente cliente){
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteRepository.save(cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> deleteCliente(@PathVariable Long id){
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isPresent()){
            clienteRepository.delete(cliente.get());
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }


}
