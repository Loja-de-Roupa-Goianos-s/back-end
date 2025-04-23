package com.ecommerce.lojavirtual.repository;

import com.ecommerce.lojavirtual.model.Pedido;
import com.ecommerce.lojavirtual.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByUsuario(Usuario usuario);
    Page<Pedido> findByUsuario(Usuario usuario, Pageable pageable);
    Optional<Pedido> findByCodigoPedido(String codigoPedido);
}