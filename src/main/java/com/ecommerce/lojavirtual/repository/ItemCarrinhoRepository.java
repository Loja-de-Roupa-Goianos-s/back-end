package com.ecommerce.lojavirtual.repository;

import com.ecommerce.lojavirtual.model.Carrinho;
import com.ecommerce.lojavirtual.model.ItemCarrinho;
import com.ecommerce.lojavirtual.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemCarrinhoRepository extends JpaRepository<ItemCarrinho, Long> {
    Optional<ItemCarrinho> findByCarrinhoAndProduto(Carrinho carrinho, Produto produto);
}