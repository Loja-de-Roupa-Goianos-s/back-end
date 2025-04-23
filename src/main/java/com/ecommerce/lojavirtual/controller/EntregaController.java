package com.ecommerce.lojavirtual.controller;

import com.ecommerce.lojavirtual.dto.EntregaDTO;
import com.ecommerce.lojavirtual.model.Entrega;
import com.ecommerce.lojavirtual.service.EntregaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/entregas")
@RequiredArgsConstructor
public class EntregaController {

    private final EntregaService entregaService;

    @GetMapping("/pedido/{pedidoId}")
    public ResponseEntity<EntregaDTO> buscarEntregaPorPedidoId(@PathVariable Long pedidoId) {
        EntregaDTO entrega = entregaService.buscarEntregaPorPedidoId(pedidoId);
        return ResponseEntity.ok(entrega);
    }

    @PutMapping("/pedido/{pedidoId}/status")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<EntregaDTO> atualizarStatusEntrega(
            @PathVariable Long pedidoId,
            @RequestBody Map<String, String> request) {
        Entrega.StatusEntrega novoStatus = Entrega.StatusEntrega.valueOf(request.get("status"));
        EntregaDTO entrega = entregaService.atualizarStatusEntrega(pedidoId, novoStatus);
        return ResponseEntity.ok(entrega);
    }
}