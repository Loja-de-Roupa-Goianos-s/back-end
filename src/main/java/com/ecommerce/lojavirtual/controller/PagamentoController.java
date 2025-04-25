package com.ecommerce.lojavirtual.controller;

import com.ecommerce.lojavirtual.dto.PagamentoDTO;
import com.ecommerce.lojavirtual.model.Pagamento;
import com.ecommerce.lojavirtual.service.PagamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/pagamentos")
@RequiredArgsConstructor
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @GetMapping("/pedido/{pedidoId}")
    public ResponseEntity<PagamentoDTO> buscarPagamentoPorPedidoId(@PathVariable Long pedidoId) {
        PagamentoDTO pagamento = pagamentoService.buscarPagamentoPorPedidoId(pedidoId);
        return ResponseEntity.ok(pagamento);
    }

    @PutMapping("/pedido/{pedidoId}/status")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<PagamentoDTO> atualizarStatusPagamento(
            @PathVariable Long pedidoId,
            @RequestBody Map<String, String> request) {
        Pagamento.StatusPagamento novoStatus = Pagamento.StatusPagamento.valueOf(request.get("status"));
        PagamentoDTO pagamento = pagamentoService.atualizarStatusPagamento(pedidoId, novoStatus);
        return ResponseEntity.ok(pagamento);
    }
}