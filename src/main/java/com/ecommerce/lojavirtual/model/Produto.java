package com.ecommerce.lojavirtual.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome do produto é obrigatório")
    private String nome;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @NotNull(message = "Preço é obrigatório")
    @Positive(message = "Preço deve ser maior que zero")
    private BigDecimal preco;

    @NotNull(message = "Quantidade em estoque é obrigatória")
    @Positive(message = "Quantidade em estoque deve ser maior que zero")
    private Integer quantidadeEstoque;

    @Column(unique = true)
    private String codigoProduto;

    private boolean ativo = true;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @OneToMany(mappedBy = "produto")
    private List<ItemCarrinho> itensCarrinho;

    @OneToMany(mappedBy = "produto")
    private List<ItemPedido> itensPedido;

    public Produto(Long id, @NotBlank(message = "Nome do produto é obrigatório") String nome, String descricao, @NotNull(message = "Preço é obrigatório") @Positive(message = "Preço deve ser maior que zero") BigDecimal preco, @NotNull(message = "Quantidade em estoque é obrigatória") @Positive(message = "Quantidade em estoque deve ser maior que zero") Integer quantidadeEstoque, String codigoProduto, boolean ativo, Usuario usuario, Categoria categoria, List<ItemCarrinho> itensCarrinho, List<ItemPedido> itensPedido) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
        this.codigoProduto = codigoProduto;
        this.ativo = ativo;
        this.usuario = usuario;
        this.categoria = categoria;
        this.itensCarrinho = itensCarrinho;
        this.itensPedido = itensPedido;
    }

    public Produto() {
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

    public Usuario getUsuario() {
        return this.usuario;
    }

    public Categoria getCategoria() {
        return this.categoria;
    }

    public List<ItemCarrinho> getItensCarrinho() {
        return this.itensCarrinho;
    }

    public List<ItemPedido> getItensPedido() {
        return this.itensPedido;
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

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setItensCarrinho(List<ItemCarrinho> itensCarrinho) {
        this.itensCarrinho = itensCarrinho;
    }

    public void setItensPedido(List<ItemPedido> itensPedido) {
        this.itensPedido = itensPedido;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Produto)) return false;
        final Produto other = (Produto) o;
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
        final Object this$usuario = this.getUsuario();
        final Object other$usuario = other.getUsuario();
        if (this$usuario == null ? other$usuario != null : !this$usuario.equals(other$usuario)) return false;
        final Object this$categoria = this.getCategoria();
        final Object other$categoria = other.getCategoria();
        if (this$categoria == null ? other$categoria != null : !this$categoria.equals(other$categoria)) return false;
        final Object this$itensCarrinho = this.getItensCarrinho();
        final Object other$itensCarrinho = other.getItensCarrinho();
        if (this$itensCarrinho == null ? other$itensCarrinho != null : !this$itensCarrinho.equals(other$itensCarrinho))
            return false;
        final Object this$itensPedido = this.getItensPedido();
        final Object other$itensPedido = other.getItensPedido();
        if (this$itensPedido == null ? other$itensPedido != null : !this$itensPedido.equals(other$itensPedido))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Produto;
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
        final Object $usuario = this.getUsuario();
        result = result * PRIME + ($usuario == null ? 43 : $usuario.hashCode());
        final Object $categoria = this.getCategoria();
        result = result * PRIME + ($categoria == null ? 43 : $categoria.hashCode());
        final Object $itensCarrinho = this.getItensCarrinho();
        result = result * PRIME + ($itensCarrinho == null ? 43 : $itensCarrinho.hashCode());
        final Object $itensPedido = this.getItensPedido();
        result = result * PRIME + ($itensPedido == null ? 43 : $itensPedido.hashCode());
        return result;
    }

    public String toString() {
        return "Produto(id=" + this.getId() + ", nome=" + this.getNome() + ", descricao=" + this.getDescricao() + ", preco=" + this.getPreco() + ", quantidadeEstoque=" + this.getQuantidadeEstoque() + ", codigoProduto=" + this.getCodigoProduto() + ", ativo=" + this.isAtivo() + ", usuario=" + this.getUsuario() + ", categoria=" + this.getCategoria() + ", itensCarrinho=" + this.getItensCarrinho() + ", itensPedido=" + this.getItensPedido() + ")";
    }
}