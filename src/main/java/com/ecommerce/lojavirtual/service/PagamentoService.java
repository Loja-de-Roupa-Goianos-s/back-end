package com.ecommerce.lojavirtual.service;

import com.ecommerce.lojavirtual.dto.PagamentoDTO;
import com.ecommerce.lojavirtual.exception.RecursoNaoEncontradoException;
import com.ecommerce.lojavirtual.model.Pagamento;
import com.ecommerce.lojavirtual.model.Pedido;
import com.ecommerce.lojavirtual.repository.PagamentoRepository;
import com.ecommerce.lojavirtual.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;
    @Autowired
    private PedidoRepository pedidoRepository;

    public PagamentoDTO buscarPagamentoPorPedidoId(Long pedidoId) {
        Pedido pedido = pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Pedido não encontrado com o ID: " + pedidoId));

        Pagamento pagamento = pagamentoRepository.findByPedido(pedido)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Pagamento não encontrado para o pedido com ID: " + pedidoId));

        return converterParaDTO(pagamento);
    }

    @Transactional
    public PagamentoDTO atualizarStatusPagamento(Long pedidoId, Pagamento.StatusPagamento novoStatus) {
        Pedido pedido = pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Pedido não encontrado com o ID: " + pedidoId));

        Pagamento pagamento = pagamentoRepository.findByPedido(pedido)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Pagamento não encontrado para o pedido com ID: " + pedidoId));

        pagamento.setStatusPagamento(novoStatus);

        if (novoStatus == Pagamento.StatusPagamento.APROVADO) {
            pagamento.setDataPagamento(LocalDateTime.now());
            pedido.setStatus(Pedido.StatusPedido.APROVADO);
            pedidoRepository.save(pedido);
        } else if (novoStatus == Pagamento.StatusPagamento.RECUSADO) {
            pedido.setStatus(Pedido.StatusPedido.NEGADO);
            pedidoRepository.save(pedido);
        }

        Pagamento pagamentoAtualizado = pagamentoRepository.save(pagamento);
        return converterParaDTO(pagamentoAtualizado);
    }

    private PagamentoDTO converterParaDTO(Pagamento pagamento) {
        PagamentoDTO dto = new PagamentoDTO();
        dto.setId(pagamento.getId());
        dto.setMetodoPagamento(pagamento.getMetodoPagamento());
        dto.setStatusPagamento(pagamento.getStatusPagamento());
        dto.setValorPago(pagamento.getValorPago());
        dto.setDataPagamento(pagamento.getDataPagamento());
        return dto;
    }
}