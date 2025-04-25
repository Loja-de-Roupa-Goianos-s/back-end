package com.ecommerce.lojavirtual.controller;

import com.ecommerce.lojavirtual.dto.CriacaoPedidoDTO;
import com.ecommerce.lojavirtual.dto.PedidoDTO;
import com.ecommerce.lojavirtual.model.Pedido;
import com.ecommerce.lojavirtual.model.Usuario;
import com.ecommerce.lojavirtual.service.PedidoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    @Autowired
    private  PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<Page<PedidoDTO>> listarPedidosDoUsuario(
            @AuthenticationPrincipal Usuario usuario,
            Pageable pageable) {
        Page<PedidoDTO> pedidos = pedidoService.listarPedidosPorUsuario(usuario.getId(), pageable);
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> buscarPedidoPorId(@PathVariable Long id) {
        PedidoDTO pedido = pedidoService.buscarPedidoPorId(id);
        return ResponseEntity.ok(pedido);
    }

    @PostMapping
    public ResponseEntity<PedidoDTO> criarPedido(
            @Valid @RequestBody CriacaoPedidoDTO criacaoPedidoDTO,
            @AuthenticationPrincipal Usuario usuario) {
        PedidoDTO pedido = pedidoService.criarPedido(usuario.getId(), criacaoPedidoDTO);
        return ResponseEntity.ok(pedido);
    }

    @PutMapping("/{id}/status")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<PedidoDTO> atualizarStatusPedido(
            @PathVariable Long id,
            @RequestBody Map<String, String> request) {
        Pedido.StatusPedido novoStatus = Pedido.StatusPedido.valueOf(request.get("status"));
        PedidoDTO pedido = pedidoService.atualizarStatusPedido(id, novoStatus);
        return ResponseEntity.ok(pedido);
    }
}