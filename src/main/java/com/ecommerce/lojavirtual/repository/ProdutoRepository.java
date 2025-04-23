package com.ecommerce.lojavirtual.repository;

import com.ecommerce.lojavirtual.model.Categoria;
import com.ecommerce.lojavirtual.model.Produto;
import com.ecommerce.lojavirtual.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Page<Produto> findByAtivoTrue(Pageable pageable);
    Page<Produto> findByCategoria(Categoria categoria, Pageable pageable);
    Page<Produto> findByNomeContainingIgnoreCase(String nome, Pageable pageable);
    List<Produto> findByUsuario(Usuario usuario);
    Optional<Produto> findByCodigoProduto(String codigoProduto);
    boolean existsByCodigoProduto(String codigoProduto);
}