package com.ecommerce.lojavirtual.controller;

import com.ecommerce.lojavirtual.dto.CarrinhoDTO;
import com.ecommerce.lojavirtual.dto.ItemCarrinhoDTO;
import com.ecommerce.lojavirtual.model.Usuario;
import com.ecommerce.lojavirtual.service.CarrinhoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carrinho")
@RequiredArgsConstructor
public class CarrinhoController {

    private final CarrinhoService carrinhoService;

    @GetMapping
    public ResponseEntity<CarrinhoDTO> buscarCarrinho(@AuthenticationPrincipal Usuario usuario) {
        CarrinhoDTO carrinho = carrinhoService.buscarCarrinhoPorUsuario(usuario.getId());
        return ResponseEntity.ok(carrinho);
    }

    @PostMapping("/itens")
    public ResponseEntity<CarrinhoDTO> adicionarItemAoCarrinho(
            @Valid @RequestBody ItemCarrinhoDTO itemDTO,
            @AuthenticationPrincipal Usuario usuario) {
        CarrinhoDTO carrinho = carrinhoService.adicionarItemAoCarrinho(usuario.getId(), itemDTO);
        return ResponseEntity.ok(carrinho);
    }

    @PutMapping("/itens/{itemId}")
    public ResponseEntity<CarrinhoDTO> atualizarItemDoCarrinho(
            @PathVariable Long itemId,
            @Valid @RequestBody ItemCarrinhoDTO itemDTO,
            @AuthenticationPrincipal Usuario usuario) {
        CarrinhoDTO carrinho = carrinhoService.atualizarItemDoCarrinho(usuario.getId(), itemId, itemDTO);
        return ResponseEntity.ok(carrinho);
    }

    @DeleteMapping("/itens/{itemId}")
    public ResponseEntity<CarrinhoDTO> removerItemDoCarrinho(
            @PathVariable Long itemId,
            @AuthenticationPrincipal Usuario usuario) {
        CarrinhoDTO carrinho = carrinhoService.removerItemDoCarrinho(usuario.getId(), itemId);
        return ResponseEntity.ok(carrinho);
    }

    @DeleteMapping
    public ResponseEntity<?> limparCarrinho(@AuthenticationPrincipal Usuario usuario) {
        carrinhoService.limparCarrinho(usuario.getId());
        return ResponseEntity.ok().build();
    }
}