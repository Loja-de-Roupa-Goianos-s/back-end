package com.ecommerce.lojavirtual.repository;

import com.ecommerce.lojavirtual.model.ItemPedido;
import com.ecommerce.lojavirtual.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
    List<ItemPedido> findByPedido(Pedido pedido);
}