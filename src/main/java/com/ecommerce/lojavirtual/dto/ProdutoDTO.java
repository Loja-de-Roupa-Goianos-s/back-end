package com.ecommerce.lojavirtual.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class ProdutoDTO {
    private Long id;

    @NotBlank(message = "Nome do produto é obrigatório")
    private String nome;

    private String descricao;

    @NotNull(message = "Preço é obrigatório")
    @Positive(message = "Preço deve ser maior que zero")
    private BigDecimal preco;

    @NotNull(message = "Quantidade em estoque é obrigatória")
    @Positive(message = "Quantidade em estoque deve ser maior que zero")
    private Integer quantidadeEstoque;

    private String codigoProduto;

    private boolean ativo;

    @NotNull(message = "Categoria é obrigatória")
    private Long categoriaId;

    public ProdutoDTO(Long id, @NotBlank(message = "Nome do produto é obrigatório") String nome, String descricao, @NotNull(message = "Preço é obrigatório") @Positive(message = "Preço deve ser maior que zero") BigDecimal preco, @NotNull(message = "Quantidade em estoque é obrigatória") @Positive(message = "Quantidade em estoque deve ser maior que zero") Integer quantidadeEstoque, String codigoProduto, boolean ativo, @NotNull(message = "Categoria é obrigatória") Long categoriaId) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
        this.codigoProduto = codigoProduto;
        this.ativo = ativo;
        this.categoriaId = categoriaId;
    }

    public ProdutoDTO() {
    }

    public Long getId() {
        return this.id;
    }

    public @NotBlank(message = "Nome do produto é obrigatório") String getNome() {
        return this.nome;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public @NotNull(message = "Preço é obrigatório") @Positive(message = "Preço deve ser maior que zero") BigDecimal getPreco() {
        return this.preco;
    }

    public @NotNull(message = "Quantidade em estoque é obrigatória") @Positive(message = "Quantidade em estoque deve ser maior que zero") Integer getQuantidadeEstoque() {
        return this.quantidadeEstoque;
    }

    public String getCodigoProduto() {
        return this.codigoProduto;
    }

    public boolean isAtivo() {
        return this.ativo;
    }

    public @NotNull(message = "Categoria é obrigatória") Long getCategoriaId() {
        return this.categoriaId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(@NotBlank(message = "Nome do produto é obrigatório") String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco(@NotNull(message = "Preço é obrigatório") @Positive(message = "Preço deve ser maior que zero") BigDecimal preco) {
        this.preco = preco;
    }

    public void setQuantidadeEstoque(@NotNull(message = "Quantidade em estoque é obrigatória") @Positive(message = "Quantidade em estoque deve ser maior que zero") Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public void setCategoriaId(@NotNull(message = "Categoria é obrigatória") Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ProdutoDTO)) return false;
        final ProdutoDTO other = (ProdutoDTO) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$nome = this.getNome();
        final Object other$nome = other.getNome();
        if (this$nome == null ? other$nome != null : !this$nome.equals(other$nome)) return false;
        final Object this$descricao = this.getDescricao();
        final Object other$descricao = other.getDescricao();
        if (this$descricao == null ? other$descricao != null : !this$descricao.equals(other$descricao)) return false;
        final Object this$preco = this.getPreco();
        final Object other$preco = other.getPreco();
        if (this$preco == null ? other$preco != null : !this$preco.equals(other$preco)) return false;
        final Object this$quantidadeEstoque = this.getQuantidadeEstoque();
        final Object other$quantidadeEstoque = other.getQuantidadeEstoque();
        if (this$quantidadeEstoque == null ? other$quantidadeEstoque != null : !this$quantidadeEstoque.equals(other$quantidadeEstoque))
            return false;
        final Object this$codigoProduto = this.getCodigoProduto();
        final Object other$codigoProduto = other.getCodigoProduto();
        if (this$codigoProduto == null ? other$codigoProduto != null : !this$codigoProduto.equals(other$codigoProduto))
            return false;
        if (this.isAtivo() != other.isAtivo()) return false;
        final Object this$categoriaId = this.getCategoriaId();
        final Object other$categoriaId = other.getCategoriaId();
        if (this$categoriaId == null ? other$categoriaId != null : !this$categoriaId.equals(other$categoriaId))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ProdutoDTO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $nome = this.getNome();
        result = result * PRIME + ($nome == null ? 43 : $nome.hashCode());
        final Object $descricao = this.getDescricao();
        result = result * PRIME + ($descricao == null ? 43 : $descricao.hashCode());
        final Object $preco = this.getPreco();
        result = result * PRIME + ($preco == null ? 43 : $preco.hashCode());
        final Object $quantidadeEstoque = this.getQuantidadeEstoque();
        result = result * PRIME + ($quantidadeEstoque == null ? 43 : $quantidadeEstoque.hashCode());
        final Object $codigoProduto = this.getCodigoProduto();
        result = result * PRIME + ($codigoProduto == null ? 43 : $codigoProduto.hashCode());
        result = result * PRIME + (this.isAtivo() ? 79 : 97);
        final Object $categoriaId = this.getCategoriaId();
        result = result * PRIME + ($categoriaId == null ? 43 : $categoriaId.hashCode());
        return result;
    }

    public String toString() {
        return "ProdutoDTO(id=" + this.getId() + ", nome=" + this.getNome() + ", descricao=" + this.getDescricao() + ", preco=" + this.getPreco() + ", quantidadeEstoque=" + this.getQuantidadeEstoque() + ", codigoProduto=" + this.getCodigoProduto() + ", ativo=" + this.isAtivo() + ", categoriaId=" + this.getCategoriaId() + ")";
    }
}