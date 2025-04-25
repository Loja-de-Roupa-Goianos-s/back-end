package com.ecommerce.lojavirtual.dto;

import com.ecommerce.lojavirtual.model.Pedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    public PedidoDTO(Long id, String codigoPedido, LocalDateTime dataPedido, Pedido.StatusPedido status, Pedido.FormaPagamento formaPagamento, String enderecoEntregaRua, String enderecoEntregaNumero, String enderecoEntregaBairro, String enderecoEntregaCidade, String enderecoEntregaEstado, String enderecoEntregaCep, List<ItemPedidoDTO> itens, BigDecimal valorTotal, PagamentoDTO pagamento, EntregaDTO entrega) {
        this.id = id;
        this.codigoPedido = codigoPedido;
        this.dataPedido = dataPedido;
        this.status = status;
        this.formaPagamento = formaPagamento;
        this.enderecoEntregaRua = enderecoEntregaRua;
        this.enderecoEntregaNumero = enderecoEntregaNumero;
        this.enderecoEntregaBairro = enderecoEntregaBairro;
        this.enderecoEntregaCidade = enderecoEntregaCidade;
        this.enderecoEntregaEstado = enderecoEntregaEstado;
        this.enderecoEntregaCep = enderecoEntregaCep;
        this.itens = itens;
        this.valorTotal = valorTotal;
        this.pagamento = pagamento;
        this.entrega = entrega;
    }

    public PedidoDTO() {
    }

    public Long getId() {
        return this.id;
    }

    public String getCodigoPedido() {
        return this.codigoPedido;
    }

    public LocalDateTime getDataPedido() {
        return this.dataPedido;
    }

    public Pedido.StatusPedido getStatus() {
        return this.status;
    }

    public Pedido.FormaPagamento getFormaPagamento() {
        return this.formaPagamento;
    }

    public String getEnderecoEntregaRua() {
        return this.enderecoEntregaRua;
    }

    public String getEnderecoEntregaNumero() {
        return this.enderecoEntregaNumero;
    }

    public String getEnderecoEntregaBairro() {
        return this.enderecoEntregaBairro;
    }

    public String getEnderecoEntregaCidade() {
        return this.enderecoEntregaCidade;
    }

    public String getEnderecoEntregaEstado() {
        return this.enderecoEntregaEstado;
    }

    public String getEnderecoEntregaCep() {
        return this.enderecoEntregaCep;
    }

    public List<ItemPedidoDTO> getItens() {
        return this.itens;
    }

    public BigDecimal getValorTotal() {
        return this.valorTotal;
    }

    public PagamentoDTO getPagamento() {
        return this.pagamento;
    }

    public EntregaDTO getEntrega() {
        return this.entrega;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCodigoPedido(String codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public void setDataPedido(LocalDateTime dataPedido) {
        this.dataPedido = dataPedido;
    }

    public void setStatus(Pedido.StatusPedido status) {
        this.status = status;
    }

    public void setFormaPagamento(Pedido.FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public void setEnderecoEntregaRua(String enderecoEntregaRua) {
        this.enderecoEntregaRua = enderecoEntregaRua;
    }

    public void setEnderecoEntregaNumero(String enderecoEntregaNumero) {
        this.enderecoEntregaNumero = enderecoEntregaNumero;
    }

    public void setEnderecoEntregaBairro(String enderecoEntregaBairro) {
        this.enderecoEntregaBairro = enderecoEntregaBairro;
    }

    public void setEnderecoEntregaCidade(String enderecoEntregaCidade) {
        this.enderecoEntregaCidade = enderecoEntregaCidade;
    }

    public void setEnderecoEntregaEstado(String enderecoEntregaEstado) {
        this.enderecoEntregaEstado = enderecoEntregaEstado;
    }

    public void setEnderecoEntregaCep(String enderecoEntregaCep) {
        this.enderecoEntregaCep = enderecoEntregaCep;
    }

    public void setItens(List<ItemPedidoDTO> itens) {
        this.itens = itens;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setPagamento(PagamentoDTO pagamento) {
        this.pagamento = pagamento;
    }

    public void setEntrega(EntregaDTO entrega) {
        this.entrega = entrega;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof PedidoDTO)) return false;
        final PedidoDTO other = (PedidoDTO) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$codigoPedido = this.getCodigoPedido();
        final Object other$codigoPedido = other.getCodigoPedido();
        if (this$codigoPedido == null ? other$codigoPedido != null : !this$codigoPedido.equals(other$codigoPedido))
            return false;
        final Object this$dataPedido = this.getDataPedido();
        final Object other$dataPedido = other.getDataPedido();
        if (this$dataPedido == null ? other$dataPedido != null : !this$dataPedido.equals(other$dataPedido))
            return false;
        final Object this$status = this.getStatus();
        final Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) return false;
        final Object this$formaPagamento = this.getFormaPagamento();
        final Object other$formaPagamento = other.getFormaPagamento();
        if (this$formaPagamento == null ? other$formaPagamento != null : !this$formaPagamento.equals(other$formaPagamento))
            return false;
        final Object this$enderecoEntregaRua = this.getEnderecoEntregaRua();
        final Object other$enderecoEntregaRua = other.getEnderecoEntregaRua();
        if (this$enderecoEntregaRua == null ? other$enderecoEntregaRua != null : !this$enderecoEntregaRua.equals(other$enderecoEntregaRua))
            return false;
        final Object this$enderecoEntregaNumero = this.getEnderecoEntregaNumero();
        final Object other$enderecoEntregaNumero = other.getEnderecoEntregaNumero();
        if (this$enderecoEntregaNumero == null ? other$enderecoEntregaNumero != null : !this$enderecoEntregaNumero.equals(other$enderecoEntregaNumero))
            return false;
        final Object this$enderecoEntregaBairro = this.getEnderecoEntregaBairro();
        final Object other$enderecoEntregaBairro = other.getEnderecoEntregaBairro();
        if (this$enderecoEntregaBairro == null ? other$enderecoEntregaBairro != null : !this$enderecoEntregaBairro.equals(other$enderecoEntregaBairro))
            return false;
        final Object this$enderecoEntregaCidade = this.getEnderecoEntregaCidade();
        final Object other$enderecoEntregaCidade = other.getEnderecoEntregaCidade();
        if (this$enderecoEntregaCidade == null ? other$enderecoEntregaCidade != null : !this$enderecoEntregaCidade.equals(other$enderecoEntregaCidade))
            return false;
        final Object this$enderecoEntregaEstado = this.getEnderecoEntregaEstado();
        final Object other$enderecoEntregaEstado = other.getEnderecoEntregaEstado();
        if (this$enderecoEntregaEstado == null ? other$enderecoEntregaEstado != null : !this$enderecoEntregaEstado.equals(other$enderecoEntregaEstado))
            return false;
        final Object this$enderecoEntregaCep = this.getEnderecoEntregaCep();
        final Object other$enderecoEntregaCep = other.getEnderecoEntregaCep();
        if (this$enderecoEntregaCep == null ? other$enderecoEntregaCep != null : !this$enderecoEntregaCep.equals(other$enderecoEntregaCep))
            return false;
        final Object this$itens = this.getItens();
        final Object other$itens = other.getItens();
        if (this$itens == null ? other$itens != null : !this$itens.equals(other$itens)) return false;
        final Object this$valorTotal = this.getValorTotal();
        final Object other$valorTotal = other.getValorTotal();
        if (this$valorTotal == null ? other$valorTotal != null : !this$valorTotal.equals(other$valorTotal))
            return false;
        final Object this$pagamento = this.getPagamento();
        final Object other$pagamento = other.getPagamento();
        if (this$pagamento == null ? other$pagamento != null : !this$pagamento.equals(other$pagamento)) return false;
        final Object this$entrega = this.getEntrega();
        final Object other$entrega = other.getEntrega();
        if (this$entrega == null ? other$entrega != null : !this$entrega.equals(other$entrega)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PedidoDTO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $codigoPedido = this.getCodigoPedido();
        result = result * PRIME + ($codigoPedido == null ? 43 : $codigoPedido.hashCode());
        final Object $dataPedido = this.getDataPedido();
        result = result * PRIME + ($dataPedido == null ? 43 : $dataPedido.hashCode());
        final Object $status = this.getStatus();
        result = result * PRIME + ($status == null ? 43 : $status.hashCode());
        final Object $formaPagamento = this.getFormaPagamento();
        result = result * PRIME + ($formaPagamento == null ? 43 : $formaPagamento.hashCode());
        final Object $enderecoEntregaRua = this.getEnderecoEntregaRua();
        result = result * PRIME + ($enderecoEntregaRua == null ? 43 : $enderecoEntregaRua.hashCode());
        final Object $enderecoEntregaNumero = this.getEnderecoEntregaNumero();
        result = result * PRIME + ($enderecoEntregaNumero == null ? 43 : $enderecoEntregaNumero.hashCode());
        final Object $enderecoEntregaBairro = this.getEnderecoEntregaBairro();
        result = result * PRIME + ($enderecoEntregaBairro == null ? 43 : $enderecoEntregaBairro.hashCode());
        final Object $enderecoEntregaCidade = this.getEnderecoEntregaCidade();
        result = result * PRIME + ($enderecoEntregaCidade == null ? 43 : $enderecoEntregaCidade.hashCode());
        final Object $enderecoEntregaEstado = this.getEnderecoEntregaEstado();
        result = result * PRIME + ($enderecoEntregaEstado == null ? 43 : $enderecoEntregaEstado.hashCode());
        final Object $enderecoEntregaCep = this.getEnderecoEntregaCep();
        result = result * PRIME + ($enderecoEntregaCep == null ? 43 : $enderecoEntregaCep.hashCode());
        final Object $itens = this.getItens();
        result = result * PRIME + ($itens == null ? 43 : $itens.hashCode());
        final Object $valorTotal = this.getValorTotal();
        result = result * PRIME + ($valorTotal == null ? 43 : $valorTotal.hashCode());
        final Object $pagamento = this.getPagamento();
        result = result * PRIME + ($pagamento == null ? 43 : $pagamento.hashCode());
        final Object $entrega = this.getEntrega();
        result = result * PRIME + ($entrega == null ? 43 : $entrega.hashCode());
        return result;
    }

    public String toString() {
        return "PedidoDTO(id=" + this.getId() + ", codigoPedido=" + this.getCodigoPedido() + ", dataPedido=" + this.getDataPedido() + ", status=" + this.getStatus() + ", formaPagamento=" + this.getFormaPagamento() + ", enderecoEntregaRua=" + this.getEnderecoEntregaRua() + ", enderecoEntregaNumero=" + this.getEnderecoEntregaNumero() + ", enderecoEntregaBairro=" + this.getEnderecoEntregaBairro() + ", enderecoEntregaCidade=" + this.getEnderecoEntregaCidade() + ", enderecoEntregaEstado=" + this.getEnderecoEntregaEstado() + ", enderecoEntregaCep=" + this.getEnderecoEntregaCep() + ", itens=" + this.getItens() + ", valorTotal=" + this.getValorTotal() + ", pagamento=" + this.getPagamento() + ", entrega=" + this.getEntrega() + ")";
    }
}