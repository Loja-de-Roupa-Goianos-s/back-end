package com.ecommerce.lojavirtual.dto;

import com.ecommerce.lojavirtual.model.Pedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {
    private Long id;
    private String codigoPedido;
    private LocalDateTime dataPedido;
    private Pedido.StatusPedido status;
    private Pedido.FormaPagamento formaPagamento;
    private String enderecoEntregaRua;
    private String enderecoEntregaNumero;
    private String enderecoEntregaBairro;
    private String enderecoEntregaCidade;
    private String enderecoEntregaEstado;
    private String enderecoEntregaCep;
    private List<ItemPedidoDTO> itens = new ArrayList<>();
    private BigDecimal valorTotal;
    private PagamentoDTO pagamento;
    private EntregaDTO entrega;
}