package com.ecommerce.lojavirtual.controller;

import com.ecommerce.lojavirtual.dto.ProdutoDTO;
import com.ecommerce.lojavirtual.model.Usuario;
import com.ecommerce.lojavirtual.service.ProdutoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<Page<ProdutoDTO>> listarProdutosAtivos(Pageable pageable) {
        Page<ProdutoDTO> produtos = produtoService.listarProdutosAtivos(pageable);
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/categoria/{categoriaId}")
    public ResponseEntity<Page<ProdutoDTO>> listarProdutosPorCategoria(
            @PathVariable Long categoriaId, Pageable pageable) {
        Page<ProdutoDTO> produtos = produtoService.listarProdutosPorCategoria(categoriaId, pageable);
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/busca")
    public ResponseEntity<Page<ProdutoDTO>> buscarProdutosPorNome(
            @RequestParam String nome, Pageable pageable) {
        Page<ProdutoDTO> produtos = produtoService.buscarProdutosPorNome(nome, pageable);
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/vendedor")
    @PreAuthorize("hasRole('VENDEDOR') or hasRole('ADMIN')")
    public ResponseEntity<List<ProdutoDTO>> listarProdutosPorVendedor(@AuthenticationPrincipal Usuario usuario) {
        List<ProdutoDTO> produtos = produtoService.listarProdutosPorVendedor(usuario.getId());
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> buscarProdutoPorId(@PathVariable Long id) {
        ProdutoDTO produto = produtoService.buscarProdutoPorId(id);
        return ResponseEntity.ok(produto);
    }

    @PostMapping
    @PreAuthorize("hasRole('VENDEDOR') or hasRole('ADMIN')")
    public ResponseEntity<ProdutoDTO> criarProduto(
            @Valid @RequestBody ProdutoDTO produtoDTO,
            @AuthenticationPrincipal Usuario usuario) {
        ProdutoDTO novoProduto = produtoService.criarProduto(produtoDTO, usuario.getId());
        return ResponseEntity.ok(novoProduto);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('VENDEDOR') or hasRole('ADMIN')")
    public ResponseEntity<ProdutoDTO> atualizarProduto(
            @PathVariable Long id,
            @Valid @RequestBody ProdutoDTO produtoDTO) {
        ProdutoDTO produtoAtualizado = produtoService.atualizarProduto(id, produtoDTO);
        return ResponseEntity.ok(produtoAtualizado);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('VENDEDOR') or hasRole('ADMIN')")
    public ResponseEntity<?> desativarProduto(@PathVariable Long id) {
        produtoService.desativarProduto(id);
        return ResponseEntity.ok().build();
    }
}