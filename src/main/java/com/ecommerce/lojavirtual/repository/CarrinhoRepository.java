package com.ecommerce.lojavirtual.repository;

import com.ecommerce.lojavirtual.model.Carrinho;
import com.ecommerce.lojavirtual.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {
    Optional<Carrinho> findByUsuarioAndItensIsNotEmpty(Usuario usuario);
}