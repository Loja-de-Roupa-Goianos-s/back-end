package com.ecommerce.lojavirtual.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDTO {
    private Long id;
    private LocalDateTime dataAtualizacao;
    private List<ItemCarrinhoDTO> itens = new ArrayList<>();
    private BigDecimal valorTotal;

    public CarrinhoDTO(Long id, LocalDateTime dataAtualizacao, List<ItemCarrinhoDTO> itens, BigDecimal valorTotal) {
        this.id = id;
        this.dataAtualizacao = dataAtualizacao;
        this.itens = itens;
        this.valorTotal = valorTotal;
    }

    public CarrinhoDTO() {
    }

    public Long getId() {
        return this.id;
    }

    public LocalDateTime getDataAtualizacao() {
        return this.dataAtualizacao;
    }

    public List<ItemCarrinhoDTO> getItens() {
        return this.itens;
    }

    public BigDecimal getValorTotal() {
        return this.valorTotal;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public void setItens(List<ItemCarrinhoDTO> itens) {
        this.itens = itens;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof CarrinhoDTO)) return false;
        final CarrinhoDTO other = (CarrinhoDTO) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$dataAtualizacao = this.getDataAtualizacao();
        final Object other$dataAtualizacao = other.getDataAtualizacao();
        if (this$dataAtualizacao == null ? other$dataAtualizacao != null : !this$dataAtualizacao.equals(other$dataAtualizacao))
            return false;
        final Object this$itens = this.getItens();
        final Object other$itens = other.getItens();
        if (this$itens == null ? other$itens != null : !this$itens.equals(other$itens)) return false;
        final Object this$valorTotal = this.getValorTotal();
        final Object other$valorTotal = other.getValorTotal();
        if (this$valorTotal == null ? other$valorTotal != null : !this$valorTotal.equals(other$valorTotal))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CarrinhoDTO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $dataAtualizacao = this.getDataAtualizacao();
        result = result * PRIME + ($dataAtualizacao == null ? 43 : $dataAtualizacao.hashCode());
        final Object $itens = this.getItens();
        result = result * PRIME + ($itens == null ? 43 : $itens.hashCode());
        final Object $valorTotal = this.getValorTotal();
        result = result * PRIME + ($valorTotal == null ? 43 : $valorTotal.hashCode());
        return result;
    }

    public String toString() {
        return "CarrinhoDTO(id=" + this.getId() + ", dataAtualizacao=" + this.getDataAtualizacao() + ", itens=" + this.getItens() + ", valorTotal=" + this.getValorTotal() + ")";
    }
}