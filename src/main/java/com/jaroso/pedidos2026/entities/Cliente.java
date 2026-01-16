package com.jaroso.pedidos2026.entities;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    private String email;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pedido> pedidos = new ArrayList<>();


    /**
     * Método para añadir un pedido a un cliente
     */
    public void addPedido(Pedido pedido) {
        pedidos.add(pedido);
        pedido.setCliente(this); //Referencia inversa
    }

}
