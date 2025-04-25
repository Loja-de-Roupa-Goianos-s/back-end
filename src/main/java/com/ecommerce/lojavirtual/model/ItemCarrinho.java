package com.ecommerce.lojavirtual.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "itens_carrinho")
public class ItemCarrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "carrinho_id", nullable = false)
    private Carrinho carrinho;

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

    @NotNull(message = "Quantidade é obrigatória")
    @Positive(message = "Quantidade deve ser maior que zero")
    private Integer quantidade;

    public ItemCarrinho(Long id, Carrinho carrinho, Produto produto, @NotNull(message = "Quantidade é obrigatória") @Positive(message = "Quantidade deve ser maior que zero") Integer quantidade) {
        this.id = id;
        this.carrinho = carrinho;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public ItemCarrinho() {
    }

    public Long getId() {
        return this.id;
    }

    public Carrinho getCarrinho() {
        return this.carrinho;
    }

    public Produto getProduto() {
        return this.produto;
    }

    public @NotNull(message = "Quantidade é obrigatória") @Positive(message = "Quantidade deve ser maior que zero") Integer getQuantidade() {
        return this.quantidade;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setQuantidade(@NotNull(message = "Quantidade é obrigatória") @Positive(message = "Quantidade deve ser maior que zero") Integer quantidade) {
        this.quantidade = quantidade;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ItemCarrinho)) return false;
        final ItemCarrinho other = (ItemCarrinho) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$carrinho = this.getCarrinho();
        final Object other$carrinho = other.getCarrinho();
        if (this$carrinho == null ? other$carrinho != null : !this$carrinho.equals(other$carrinho)) return false;
        final Object this$produto = this.getProduto();
        final Object other$produto = other.getProduto();
        if (this$produto == null ? other$produto != null : !this$produto.equals(other$produto)) return false;
        final Object this$quantidade = this.getQuantidade();
        final Object other$quantidade = other.getQuantidade();
        if (this$quantidade == null ? other$quantidade != null : !this$quantidade.equals(other$quantidade))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ItemCarrinho;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $carrinho = this.getCarrinho();
        result = result * PRIME + ($carrinho == null ? 43 : $carrinho.hashCode());
        final Object $produto = this.getProduto();
        result = result * PRIME + ($produto == null ? 43 : $produto.hashCode());
        final Object $quantidade = this.getQuantidade();
        result = result * PRIME + ($quantidade == null ? 43 : $quantidade.hashCode());
        return result;
    }

    public String toString() {
        return "ItemCarrinho(id=" + this.getId() + ", carrinho=" + this.getCarrinho() + ", produto=" + this.getProduto() + ", quantidade=" + this.getQuantidade() + ")";
    }
}