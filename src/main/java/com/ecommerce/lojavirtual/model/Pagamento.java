package com.ecommerce.lojavirtual.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "pagamentos")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;

    @Enumerated(EnumType.STRING)
    private MetodoPagamento metodoPagamento;

    @Enumerated(EnumType.STRING)
    private StatusPagamento statusPagamento = StatusPagamento.PENDENTE;

    @NotNull(message = "Valor do pagamento é obrigatório")
    @Positive(message = "Valor do pagamento deve ser maior que zero")
    private BigDecimal valorPago;

    private LocalDateTime dataPagamento;

    public Pagamento(Long id, Pedido pedido, MetodoPagamento metodoPagamento, StatusPagamento statusPagamento, @NotNull(message = "Valor do pagamento é obrigatório") @Positive(message = "Valor do pagamento deve ser maior que zero") BigDecimal valorPago, LocalDateTime dataPagamento) {
        this.id = id;
        this.pedido = pedido;
        this.metodoPagamento = metodoPagamento;
        this.statusPagamento = statusPagamento;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
    }

    public Pagamento() {
    }

    public Long getId() {
        return this.id;
    }

    public Pedido getPedido() {
        return this.pedido;
    }

    public MetodoPagamento getMetodoPagamento() {
        return this.metodoPagamento;
    }

    public StatusPagamento getStatusPagamento() {
        return this.statusPagamento;
    }

    public @NotNull(message = "Valor do pagamento é obrigatório") @Positive(message = "Valor do pagamento deve ser maior que zero") BigDecimal getValorPago() {
        return this.valorPago;
    }

    public LocalDateTime getDataPagamento() {
        return this.dataPagamento;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public void setMetodoPagamento(MetodoPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public void setStatusPagamento(StatusPagamento statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public void setValorPago(@NotNull(message = "Valor do pagamento é obrigatório") @Positive(message = "Valor do pagamento deve ser maior que zero") BigDecimal valorPago) {
        this.valorPago = valorPago;
    }

    public void setDataPagamento(LocalDateTime dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Pagamento)) return false;
        final Pagamento other = (Pagamento) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$pedido = this.getPedido();
        final Object other$pedido = other.getPedido();
        if (this$pedido == null ? other$pedido != null : !this$pedido.equals(other$pedido)) return false;
        final Object this$metodoPagamento = this.getMetodoPagamento();
        final Object other$metodoPagamento = other.getMetodoPagamento();
        if (this$metodoPagamento == null ? other$metodoPagamento != null : !this$metodoPagamento.equals(other$metodoPagamento))
            return false;
        final Object this$statusPagamento = this.getStatusPagamento();
        final Object other$statusPagamento = other.getStatusPagamento();
        if (this$statusPagamento == null ? other$statusPagamento != null : !this$statusPagamento.equals(other$statusPagamento))
            return false;
        final Object this$valorPago = this.getValorPago();
        final Object other$valorPago = other.getValorPago();
        if (this$valorPago == null ? other$valorPago != null : !this$valorPago.equals(other$valorPago)) return false;
        final Object this$dataPagamento = this.getDataPagamento();
        final Object other$dataPagamento = other.getDataPagamento();
        if (this$dataPagamento == null ? other$dataPagamento != null : !this$dataPagamento.equals(other$dataPagamento))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Pagamento;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $pedido = this.getPedido();
        result = result * PRIME + ($pedido == null ? 43 : $pedido.hashCode());
        final Object $metodoPagamento = this.getMetodoPagamento();
        result = result * PRIME + ($metodoPagamento == null ? 43 : $metodoPagamento.hashCode());
        final Object $statusPagamento = this.getStatusPagamento();
        result = result * PRIME + ($statusPagamento == null ? 43 : $statusPagamento.hashCode());
        final Object $valorPago = this.getValorPago();
        result = result * PRIME + ($valorPago == null ? 43 : $valorPago.hashCode());
        final Object $dataPagamento = this.getDataPagamento();
        result = result * PRIME + ($dataPagamento == null ? 43 : $dataPagamento.hashCode());
        return result;
    }

    public String toString() {
        return "Pagamento(id=" + this.getId() + ", pedido=" + this.getPedido() + ", metodoPagamento=" + this.getMetodoPagamento() + ", statusPagamento=" + this.getStatusPagamento() + ", valorPago=" + this.getValorPago() + ", dataPagamento=" + this.getDataPagamento() + ")";
    }

    public enum MetodoPagamento {
        CARTAO_CREDITO, CARTAO_DEBITO, PIX, BOLETO, DINHEIRO
    }

    public enum StatusPagamento {
        PENDENTE, APROVADO, RECUSADO, ESTORNADO
    }
}