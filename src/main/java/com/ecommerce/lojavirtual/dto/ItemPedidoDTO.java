package com.ecommerce.lojavirtual.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class ItemPedidoDTO {
    private Long id;
    private Long produtoId;
    private String nomeProduto;

    @NotNull(message = "Quantidade é obrigatória")
    @Positive(message = "Quantidade deve ser maior que zero")
    private Integer quantidade;

    private BigDecimal precoUnitario;
    private BigDecimal subtotal;

    public ItemPedidoDTO(Long id, Long produtoId, String nomeProduto, @NotNull(message = "Quantidade é obrigatória") @Positive(message = "Quantidade deve ser maior que zero") Integer quantidade, BigDecimal precoUnitario, BigDecimal subtotal) {
        this.id = id;
        this.produtoId = produtoId;
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.subtotal = subtotal;
    }

    public ItemPedidoDTO() {
    }

    public Long getId() {
        return this.id;
    }

    public Long getProdutoId() {
        return this.produtoId;
    }

    public String getNomeProduto() {
        return this.nomeProduto;
    }

    public @NotNull(message = "Quantidade é obrigatória") @Positive(message = "Quantidade deve ser maior que zero") Integer getQuantidade() {
        return this.quantidade;
    }

    public BigDecimal getPrecoUnitario() {
        return this.precoUnitario;
    }

    public BigDecimal getSubtotal() {
        return this.subtotal;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public void setQuantidade(@NotNull(message = "Quantidade é obrigatória") @Positive(message = "Quantidade deve ser maior que zero") Integer quantidade) {
        this.quantidade = quantidade;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ItemPedidoDTO)) return false;
        final ItemPedidoDTO other = (ItemPedidoDTO) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$produtoId = this.getProdutoId();
        final Object other$produtoId = other.getProdutoId();
        if (this$produtoId == null ? other$produtoId != null : !this$produtoId.equals(other$produtoId)) return false;
        final Object this$nomeProduto = this.getNomeProduto();
        final Object other$nomeProduto = other.getNomeProduto();
        if (this$nomeProduto == null ? other$nomeProduto != null : !this$nomeProduto.equals(other$nomeProduto))
            return false;
        final Object this$quantidade = this.getQuantidade();
        final Object other$quantidade = other.getQuantidade();
        if (this$quantidade == null ? other$quantidade != null : !this$quantidade.equals(other$quantidade))
            return false;
        final Object this$precoUnitario = this.getPrecoUnitario();
        final Object other$precoUnitario = other.getPrecoUnitario();
        if (this$precoUnitario == null ? other$precoUnitario != null : !this$precoUnitario.equals(other$precoUnitario))
            return false;
        final Object this$subtotal = this.getSubtotal();
        final Object other$subtotal = other.getSubtotal();
        if (this$subtotal == null ? other$subtotal != null : !this$subtotal.equals(other$subtotal)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ItemPedidoDTO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $produtoId = this.getProdutoId();
        result = result * PRIME + ($produtoId == null ? 43 : $produtoId.hashCode());
        final Object $nomeProduto = this.getNomeProduto();
        result = result * PRIME + ($nomeProduto == null ? 43 : $nomeProduto.hashCode());
        final Object $quantidade = this.getQuantidade();
        result = result * PRIME + ($quantidade == null ? 43 : $quantidade.hashCode());
        final Object $precoUnitario = this.getPrecoUnitario();
        result = result * PRIME + ($precoUnitario == null ? 43 : $precoUnitario.hashCode());
        final Object $subtotal = this.getSubtotal();
        result = result * PRIME + ($subtotal == null ? 43 : $subtotal.hashCode());
        return result;
    }

    public String toString() {
        return "ItemPedidoDTO(id=" + this.getId() + ", produtoId=" + this.getProdutoId() + ", nomeProduto=" + this.getNomeProduto() + ", quantidade=" + this.getQuantidade() + ", precoUnitario=" + this.getPrecoUnitario() + ", subtotal=" + this.getSubtotal() + ")";
    }
}