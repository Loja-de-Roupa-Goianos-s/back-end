package com.ecommerce.lojavirtual.dto;

import com.ecommerce.lojavirtual.model.Pagamento;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PagamentoDTO {
    private Long id;
    private Pagamento.MetodoPagamento metodoPagamento;
    private Pagamento.StatusPagamento statusPagamento;

    @NotNull(message = "Valor do pagamento é obrigatório")
    @Positive(message = "Valor do pagamento deve ser maior que zero")
    private BigDecimal valorPago;

    private LocalDateTime dataPagamento;

    public PagamentoDTO(Long id, Pagamento.MetodoPagamento metodoPagamento, Pagamento.StatusPagamento statusPagamento, @NotNull(message = "Valor do pagamento é obrigatório") @Positive(message = "Valor do pagamento deve ser maior que zero") BigDecimal valorPago, LocalDateTime dataPagamento) {
        this.id = id;
        this.metodoPagamento = metodoPagamento;
        this.statusPagamento = statusPagamento;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
    }

    public PagamentoDTO() {
    }

    public Long getId() {
        return this.id;
    }

    public Pagamento.MetodoPagamento getMetodoPagamento() {
        return this.metodoPagamento;
    }

    public Pagamento.StatusPagamento getStatusPagamento() {
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

    public void setMetodoPagamento(Pagamento.MetodoPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public void setStatusPagamento(Pagamento.StatusPagamento statusPagamento) {
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
        if (!(o instanceof PagamentoDTO)) return false;
        final PagamentoDTO other = (PagamentoDTO) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
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
        return other instanceof PagamentoDTO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
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
        return "PagamentoDTO(id=" + this.getId() + ", metodoPagamento=" + this.getMetodoPagamento() + ", statusPagamento=" + this.getStatusPagamento() + ", valorPago=" + this.getValorPago() + ", dataPagamento=" + this.getDataPagamento() + ")";
    }
}