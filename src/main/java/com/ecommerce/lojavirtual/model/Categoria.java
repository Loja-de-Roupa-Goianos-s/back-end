package com.ecommerce.lojavirtual.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome da categoria é obrigatório")
    @Column(unique = true)
    private String nome;

    @OneToMany(mappedBy = "categoria")
    private List<Produto> produtos;

    public Categoria(Long id, @NotBlank(message = "Nome da categoria é obrigatório") String nome, List<Produto> produtos) {
        this.id = id;
        this.nome = nome;
        this.produtos = produtos;
    }

    public Categoria() {
    }

    public Long getId() {
        return this.id;
    }

    public @NotBlank(message = "Nome da categoria é obrigatório") String getNome() {
        return this.nome;
    }

    public List<Produto> getProdutos() {
        return this.produtos;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(@NotBlank(message = "Nome da categoria é obrigatório") String nome) {
        this.nome = nome;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Categoria)) return false;
        final Categoria other = (Categoria) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$nome = this.getNome();
        final Object other$nome = other.getNome();
        if (this$nome == null ? other$nome != null : !this$nome.equals(other$nome)) return false;
        final Object this$produtos = this.getProdutos();
        final Object other$produtos = other.getProdutos();
        if (this$produtos == null ? other$produtos != null : !this$produtos.equals(other$produtos)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Categoria;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $nome = this.getNome();
        result = result * PRIME + ($nome == null ? 43 : $nome.hashCode());
        final Object $produtos = this.getProdutos();
        result = result * PRIME + ($produtos == null ? 43 : $produtos.hashCode());
        return result;
    }

    public String toString() {
        return "Categoria(id=" + this.getId() + ", nome=" + this.getNome() + ", produtos=" + this.getProdutos() + ")";
    }
}