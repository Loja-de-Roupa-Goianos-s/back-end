package com.ecommerce.lojavirtual.repository;

import com.ecommerce.lojavirtual.model.Pagamento;
import com.ecommerce.lojavirtual.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
    Optional<Pagamento> findByPedido(Pedido pedido);
}