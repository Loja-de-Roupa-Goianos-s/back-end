package com.ecommerce.lojavirtual.repository;

import com.ecommerce.lojavirtual.model.Entrega;
import com.ecommerce.lojavirtual.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long> {
    Optional<Entrega> findByPedido(Pedido pedido);
}