package com.ecommerce.lojavirtual.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

@Entity
@Table(name = "itens_pedido")
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

    @NotNull(message = "Quantidade é obrigatória")
    @Positive(message = "Quantidade deve ser maior que zero")
    private Integer quantidade;

    @NotNull(message = "Preço unitário é obrigatório")
    @Positive(message = "Preço unitário deve ser maior que zero")
    private BigDecimal precoUnitario;

    public ItemPedido(Long id, Pedido pedido, Produto produto, @NotNull(message = "Quantidade é obrigatória") @Positive(message = "Quantidade deve ser maior que zero") Integer quantidade, @NotNull(message = "Preço unitário é obrigatório") @Positive(message = "Preço unitário deve ser maior que zero") BigDecimal precoUnitario) {
        this.id = id;
        this.pedido = pedido;
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    public ItemPedido() {
    }

    public Long getId() {
        return this.id;
    }

    public Pedido getPedido() {
        return this.pedido;
    }

    public Produto getProduto() {
        return this.produto;
    }

    public @NotNull(message = "Quantidade é obrigatória") @Positive(message = "Quantidade deve ser maior que zero") Integer getQuantidade() {
        return this.quantidade;
    }

    public @NotNull(message = "Preço unitário é obrigatório") @Positive(message = "Preço unitário deve ser maior que zero") BigDecimal getPrecoUnitario() {
        return this.precoUnitario;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setQuantidade(@NotNull(message = "Quantidade é obrigatória") @Positive(message = "Quantidade deve ser maior que zero") Integer quantidade) {
        this.quantidade = quantidade;
    }

    public void setPrecoUnitario(@NotNull(message = "Preço unitário é obrigatório") @Positive(message = "Preço unitário deve ser maior que zero") BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ItemPedido)) return false;
        final ItemPedido other = (ItemPedido) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$pedido = this.getPedido();
        final Object other$pedido = other.getPedido();
        if (this$pedido == null ? other$pedido != null : !this$pedido.equals(other$pedido)) return false;
        final Object this$produto = this.getProduto();
        final Object other$produto = other.getProduto();
        if (this$produto == null ? other$produto != null : !this$produto.equals(other$produto)) return false;
        final Object this$quantidade = this.getQuantidade();
        final Object other$quantidade = other.getQuantidade();
        if (this$quantidade == null ? other$quantidade != null : !this$quantidade.equals(other$quantidade))
            return false;
        final Object this$precoUnitario = this.getPrecoUnitario();
        final Object other$precoUnitario = other.getPrecoUnitario();
        if (this$precoUnitario == null ? other$precoUnitario != null : !this$precoUnitario.equals(other$precoUnitario))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ItemPedido;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $pedido = this.getPedido();
        result = result * PRIME + ($pedido == null ? 43 : $pedido.hashCode());
        final Object $produto = this.getProduto();
        result = result * PRIME + ($produto == null ? 43 : $produto.hashCode());
        final Object $quantidade = this.getQuantidade();
        result = result * PRIME + ($quantidade == null ? 43 : $quantidade.hashCode());
        final Object $precoUnitario = this.getPrecoUnitario();
        result = result * PRIME + ($precoUnitario == null ? 43 : $precoUnitario.hashCode());
        return result;
    }

    public String toString() {
        return "ItemPedido(id=" + this.getId() + ", pedido=" + this.getPedido() + ", produto=" + this.getProduto() + ", quantidade=" + this.getQuantidade() + ", precoUnitario=" + this.getPrecoUnitario() + ")";
    }
}