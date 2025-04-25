package com.ecommerce.lojavirtual.service;

import com.ecommerce.lojavirtual.dto.EntregaDTO;
import com.ecommerce.lojavirtual.exception.RecursoNaoEncontradoException;
import com.ecommerce.lojavirtual.model.Entrega;
import com.ecommerce.lojavirtual.model.Pedido;
import com.ecommerce.lojavirtual.repository.EntregaRepository;
import com.ecommerce.lojavirtual.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EntregaService {

    @Autowired
    private  EntregaRepository entregaRepository;
    @Autowired
    private  PedidoRepository pedidoRepository;

    public EntregaDTO buscarEntregaPorPedidoId(Long pedidoId) {
        Pedido pedido = pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Pedido não encontrado com o ID: " + pedidoId));

        Entrega entrega = entregaRepository.findByPedido(pedido)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Entrega não encontrada para o pedido com ID: " + pedidoId));

        return converterParaDTO(entrega);
    }

    @Transactional
    public EntregaDTO atualizarStatusEntrega(Long pedidoId, Entrega.StatusEntrega novoStatus) {
        Pedido pedido = pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Pedido não encontrado com o ID: " + pedidoId));

        Entrega entrega = entregaRepository.findByPedido(pedido)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Entrega não encontrada para o pedido com ID: " + pedidoId));

        entrega.setStatusEntrega(novoStatus);

        if (novoStatus == Entrega.StatusEntrega.EM_TRANSITO && entrega.getDataEnvio() == null) {
            entrega.setDataEnvio(LocalDateTime.now());
            entrega.setCodigoRastreio(gerarCodigoRastreio());
        } else if (novoStatus == Entrega.StatusEntrega.ENTREGUE) {
            entrega.setDataEntregaEfetiva(LocalDateTime.now());
        }

        Entrega entregaAtualizada = entregaRepository.save(entrega);
        return converterParaDTO(entregaAtualizada);
    }

    private String gerarCodigoRastreio() {
        return "TRACK-" + UUID.randomUUID().toString().substring(0, 10).toUpperCase();
    }

    private EntregaDTO converterParaDTO(Entrega entrega) {
        EntregaDTO dto = new EntregaDTO();
        dto.setId(entrega.getId());
        dto.setStatusEntrega(entrega.getStatusEntrega());
        dto.setDataEnvio(entrega.getDataEnvio());
        dto.setDataPrevistaEntrega(entrega.getDataPrevistaEntrega());
        dto.setDataEntregaEfetiva(entrega.getDataEntregaEfetiva());
        dto.setCodigoRastreio(entrega.getCodigoRastreio());
        return dto;
    }
}