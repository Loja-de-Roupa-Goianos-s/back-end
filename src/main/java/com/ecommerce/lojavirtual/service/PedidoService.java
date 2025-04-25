package com.ecommerce.lojavirtual.service;

import com.ecommerce.lojavirtual.dto.*;
import com.ecommerce.lojavirtual.exception.RecursoNaoEncontradoException;
import com.ecommerce.lojavirtual.model.*;
import com.ecommerce.lojavirtual.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PedidoService {
    @Autowired
    private  PedidoRepository pedidoRepository;
    @Autowired
    private  ItemPedidoRepository itemPedidoRepository;
    @Autowired
    private  UsuarioRepository usuarioRepository;
    @Autowired
    private  CarrinhoService carrinhoService;
    @Autowired
    private  ProdutoService produtoService;
    @Autowired
    private  PagamentoRepository pagamentoRepository;
    @Autowired
    private  EntregaRepository entregaRepository;

    public Page<PedidoDTO> listarPedidosPorUsuario(Long usuarioId, Pageable pageable) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Usuário não encontrado com o ID: " + usuarioId));

        return pedidoRepository.findByUsuario(usuario, pageable)
                .map(this::converterParaDTO);
    }

    public PedidoDTO buscarPedidoPorId(Long id) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Pedido não encontrado com o ID: " + id));

        return converterParaDTO(pedido);
    }

    @Transactional
    public PedidoDTO criarPedido(Long usuarioId, CriacaoPedidoDTO criacaoPedidoDTO) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Usuário não encontrado com o ID: " + usuarioId));

        CarrinhoDTO carrinhoDTO = carrinhoService.buscarCarrinhoPorUsuario(usuarioId);

        if (carrinhoDTO.getItens().isEmpty()) {
            throw new IllegalArgumentException("Não é possível criar um pedido com carrinho vazio");
        }

        Pedido pedido = new Pedido();
        pedido.setUsuario(usuario);
        pedido.setDataPedido(LocalDateTime.now());
        pedido.setStatus(Pedido.StatusPedido.EM_ANDAMENTO);
        pedido.setFormaPagamento(criacaoPedidoDTO.getFormaPagamento());
        pedido.setCodigoPedido(gerarCodigoPedido());

        // Configurar endereço de entrega
        if (criacaoPedidoDTO.isUsarEnderecoUsuario()) {
            pedido.setEnderecoEntregaRua(usuario.getEnderecoRua());
            pedido.setEnderecoEntregaNumero(usuario.getEnderecoNumero());
            pedido.setEnderecoEntregaBairro(usuario.getEnderecoBairro());
            pedido.setEnderecoEntregaCidade(usuario.getEnderecoCidade());
            pedido.setEnderecoEntregaEstado(usuario.getEnderecoEstado());
            pedido.setEnderecoEntregaCep(usuario.getEnderecoCep());
        } else {
            pedido.setEnderecoEntregaRua(criacaoPedidoDTO.getEnderecoEntregaRua());
            pedido.setEnderecoEntregaNumero(criacaoPedidoDTO.getEnderecoEntregaNumero());
            pedido.setEnderecoEntregaBairro(criacaoPedidoDTO.getEnderecoEntregaBairro());
            pedido.setEnderecoEntregaCidade(criacaoPedidoDTO.getEnderecoEntregaCidade());
            pedido.setEnderecoEntregaEstado(criacaoPedidoDTO.getEnderecoEntregaEstado());
            pedido.setEnderecoEntregaCep(criacaoPedidoDTO.getEnderecoEntregaCep());
        }

        Pedido pedidoSalvo = pedidoRepository.save(pedido);

        // Adicionar itens ao pedido
        BigDecimal valorTotal = BigDecimal.ZERO;

        for (ItemCarrinhoDTO itemCarrinhoDTO : carrinhoDTO.getItens()) {
            Produto produto = produtoService.buscarProdutoPorIdEntidade(itemCarrinhoDTO.getProdutoId());

            // Verificar estoque
            if (produto.getQuantidadeEstoque() < itemCarrinhoDTO.getQuantidade()) {
                throw new IllegalArgumentException("Estoque insuficiente para o produto: " + produto.getNome());
            }

            // Atualizar estoque
            produtoService.atualizarEstoque(produto.getId(), itemCarrinhoDTO.getQuantidade());

            // Criar item do pedido
            ItemPedido itemPedido = new ItemPedido();
            itemPedido.setPedido(pedidoSalvo);
            itemPedido.setProduto(produto);
            itemPedido.setQuantidade(itemCarrinhoDTO.getQuantidade());
            itemPedido.setPrecoUnitario(produto.getPreco());

            itemPedidoRepository.save(itemPedido);

            // Calcular valor total
            BigDecimal subtotal = produto.getPreco().multiply(BigDecimal.valueOf(itemCarrinhoDTO.getQuantidade()));
            valorTotal = valorTotal.add(subtotal);
        }

        // Criar pagamento
        Pagamento pagamento = new Pagamento();
        pagamento.setPedido(pedidoSalvo);
        pagamento.setMetodoPagamento(converterFormaPagamento(pedidoSalvo.getFormaPagamento()));
        pagamento.setStatusPagamento(Pagamento.StatusPagamento.PENDENTE);
        pagamento.setValorPago(valorTotal);

        pagamentoRepository.save(pagamento);

        // Criar entrega
        Entrega entrega = new Entrega();
        entrega.setPedido(pedidoSalvo);
        entrega.setStatusEntrega(Entrega.StatusEntrega.AGUARDANDO_ENVIO);
        entrega.setDataPrevistaEntrega(LocalDateTime.now().plusDays(7));

        entregaRepository.save(entrega);

        // Limpar carrinho
        carrinhoService.limparCarrinho(usuarioId);

        return buscarPedidoPorId(pedidoSalvo.getId());
    }

    @Transactional
    public PedidoDTO atualizarStatusPedido(Long id, Pedido.StatusPedido novoStatus) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Pedido não encontrado com o ID: " + id));

        pedido.setStatus(novoStatus);
        pedidoRepository.save(pedido);

        return converterParaDTO(pedido);
    }

    private String gerarCodigoPedido() {
        return "PED-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    private Pagamento.MetodoPagamento converterFormaPagamento(Pedido.FormaPagamento formaPagamento) {
        switch (formaPagamento) {
            case CARTAO:
                return Pagamento.MetodoPagamento.CARTAO_CREDITO;
            case PIX:
                return Pagamento.MetodoPagamento.PIX;
            case BOLETO:
                return Pagamento.MetodoPagamento.BOLETO;
            default:
                return Pagamento.MetodoPagamento.CARTAO_CREDITO;
        }
    }

    private PedidoDTO converterParaDTO(Pedido pedido) {
        PedidoDTO dto = new PedidoDTO();
        dto.setId(pedido.getId());
        dto.setCodigoPedido(pedido.getCodigoPedido());
        dto.setDataPedido(pedido.getDataPedido());
        dto.setStatus(pedido.getStatus());
        dto.setFormaPagamento(pedido.getFormaPagamento());
        dto.setEnderecoEntregaRua(pedido.getEnderecoEntregaRua());
        dto.setEnderecoEntregaNumero(pedido.getEnderecoEntregaNumero());
        dto.setEnderecoEntregaBairro(pedido.getEnderecoEntregaBairro());
        dto.setEnderecoEntregaCidade(pedido.getEnderecoEntregaCidade());
        dto.setEnderecoEntregaEstado(pedido.getEnderecoEntregaEstado());
        dto.setEnderecoEntregaCep(pedido.getEnderecoEntregaCep());

        List<ItemPedidoDTO> itensDTO = pedido.getItens().stream()
                .map(this::converterItemParaDTO)
                .collect(Collectors.toList());

        dto.setItens(itensDTO);

        BigDecimal valorTotal = itensDTO.stream()
                .map(ItemPedidoDTO::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        dto.setValorTotal(valorTotal);

        // Adicionar informações de pagamento
        pagamentoRepository.findByPedido(pedido).ifPresent(pagamento -> {
            PagamentoDTO pagamentoDTO = new PagamentoDTO();
            pagamentoDTO.setId(pagamento.getId());
            pagamentoDTO.setMetodoPagamento(pagamento.getMetodoPagamento());
            pagamentoDTO.setStatusPagamento(pagamento.getStatusPagamento());
            pagamentoDTO.setValorPago(pagamento.getValorPago());
            pagamentoDTO.setDataPagamento(pagamento.getDataPagamento());

            dto.setPagamento(pagamentoDTO);
        });

        // Adicionar informações de entrega
        entregaRepository.findByPedido(pedido).ifPresent(entrega -> {
            EntregaDTO entregaDTO = new EntregaDTO();
            entregaDTO.setId(entrega.getId());
            entregaDTO.setStatusEntrega(entrega.getStatusEntrega());
            entregaDTO.setDataEnvio(entrega.getDataEnvio());
            entregaDTO.setDataPrevistaEntrega(entrega.getDataPrevistaEntrega());
            entregaDTO.setDataEntregaEfetiva(entrega.getDataEntregaEfetiva());
            entregaDTO.setCodigoRastreio(entrega.getCodigoRastreio());

            dto.setEntrega(entregaDTO);
        });

        return dto;
    }

    private ItemPedidoDTO converterItemParaDTO(ItemPedido item) {
        ItemPedidoDTO dto = new ItemPedidoDTO();
        dto.setId(item.getId());
        dto.setProdutoId(item.getProduto().getId());
        dto.setNomeProduto(item.getProduto().getNome());
        dto.setQuantidade(item.getQuantidade());
        dto.setPrecoUnitario(item.getPrecoUnitario());
        dto.setSubtotal(item.getPrecoUnitario().multiply(BigDecimal.valueOf(item.getQuantidade())));
        return dto;
    }
}