package com.ecommerce.lojavirtual.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email deve ser válido")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "Senha é obrigatória")
    private String senha;

    @NotNull(message = "Data de nascimento é obrigatória")
    private LocalDate dataNascimento;

    private String enderecoRua;
    private String enderecoNumero;
    private String enderecoBairro;
    private String enderecoCidade;
    private String enderecoEstado;
    private String enderecoCep;

    @Enumerated(EnumType.STRING)
    private Role role = Role.CLIENTE;

    private boolean ativo = true;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Carrinho> carrinhos;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Pedido> pedidos;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Produto> produtos;

    public Usuario(Long id, @NotBlank(message = "Nome é obrigatório") String nome, @NotBlank(message = "Email é obrigatório") @Email(message = "Email deve ser válido") String email, @NotBlank(message = "Senha é obrigatória") String senha, @NotNull(message = "Data de nascimento é obrigatória") LocalDate dataNascimento, String enderecoRua, String enderecoNumero, String enderecoBairro, String enderecoCidade, String enderecoEstado, String enderecoCep, Role role, boolean ativo, List<Carrinho> carrinhos, List<Pedido> pedidos, List<Produto> produtos) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.enderecoRua = enderecoRua;
        this.enderecoNumero = enderecoNumero;
        this.enderecoBairro = enderecoBairro;
        this.enderecoCidade = enderecoCidade;
        this.enderecoEstado = enderecoEstado;
        this.enderecoCep = enderecoCep;
        this.role = role;
        this.ativo = ativo;
        this.carrinhos = carrinhos;
        this.pedidos = pedidos;
        this.produtos = produtos;
    }

    public Usuario() {
    }

    public Long getId() {
        return this.id;
    }

    public @NotBlank(message = "Nome é obrigatório") String getNome() {
        return this.nome;
    }

    public @NotBlank(message = "Email é obrigatório") @Email(message = "Email deve ser válido") String getEmail() {
        return this.email;
    }

    public @NotBlank(message = "Senha é obrigatória") String getSenha() {
        return this.senha;
    }

    public @NotNull(message = "Data de nascimento é obrigatória") LocalDate getDataNascimento() {
        return this.dataNascimento;
    }

    public String getEnderecoRua() {
        return this.enderecoRua;
    }

    public String getEnderecoNumero() {
        return this.enderecoNumero;
    }

    public String getEnderecoBairro() {
        return this.enderecoBairro;
    }

    public String getEnderecoCidade() {
        return this.enderecoCidade;
    }

    public String getEnderecoEstado() {
        return this.enderecoEstado;
    }

    public String getEnderecoCep() {
        return this.enderecoCep;
    }

    public Role getRole() {
        return this.role;
    }

    public boolean isAtivo() {
        return this.ativo;
    }

    public List<Carrinho> getCarrinhos() {
        return this.carrinhos;
    }

    public List<Pedido> getPedidos() {
        return this.pedidos;
    }

    public List<Produto> getProdutos() {
        return this.produtos;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(@NotBlank(message = "Nome é obrigatório") String nome) {
        this.nome = nome;
    }

    public void setEmail(@NotBlank(message = "Email é obrigatório") @Email(message = "Email deve ser válido") String email) {
        this.email = email;
    }

    public void setSenha(@NotBlank(message = "Senha é obrigatória") String senha) {
        this.senha = senha;
    }

    public void setDataNascimento(@NotNull(message = "Data de nascimento é obrigatória") LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setEnderecoRua(String enderecoRua) {
        this.enderecoRua = enderecoRua;
    }

    public void setEnderecoNumero(String enderecoNumero) {
        this.enderecoNumero = enderecoNumero;
    }

    public void setEnderecoBairro(String enderecoBairro) {
        this.enderecoBairro = enderecoBairro;
    }

    public void setEnderecoCidade(String enderecoCidade) {
        this.enderecoCidade = enderecoCidade;
    }

    public void setEnderecoEstado(String enderecoEstado) {
        this.enderecoEstado = enderecoEstado;
    }

    public void setEnderecoCep(String enderecoCep) {
        this.enderecoCep = enderecoCep;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public void setCarrinhos(List<Carrinho> carrinhos) {
        this.carrinhos = carrinhos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Usuario)) return false;
        final Usuario other = (Usuario) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$nome = this.getNome();
        final Object other$nome = other.getNome();
        if (this$nome == null ? other$nome != null : !this$nome.equals(other$nome)) return false;
        final Object this$email = this.getEmail();
        final Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
        final Object this$senha = this.getSenha();
        final Object other$senha = other.getSenha();
        if (this$senha == null ? other$senha != null : !this$senha.equals(other$senha)) return false;
        final Object this$dataNascimento = this.getDataNascimento();
        final Object other$dataNascimento = other.getDataNascimento();
        if (this$dataNascimento == null ? other$dataNascimento != null : !this$dataNascimento.equals(other$dataNascimento))
            return false;
        final Object this$enderecoRua = this.getEnderecoRua();
        final Object other$enderecoRua = other.getEnderecoRua();
        if (this$enderecoRua == null ? other$enderecoRua != null : !this$enderecoRua.equals(other$enderecoRua))
            return false;
        final Object this$enderecoNumero = this.getEnderecoNumero();
        final Object other$enderecoNumero = other.getEnderecoNumero();
        if (this$enderecoNumero == null ? other$enderecoNumero != null : !this$enderecoNumero.equals(other$enderecoNumero))
            return false;
        final Object this$enderecoBairro = this.getEnderecoBairro();
        final Object other$enderecoBairro = other.getEnderecoBairro();
        if (this$enderecoBairro == null ? other$enderecoBairro != null : !this$enderecoBairro.equals(other$enderecoBairro))
            return false;
        final Object this$enderecoCidade = this.getEnderecoCidade();
        final Object other$enderecoCidade = other.getEnderecoCidade();
        if (this$enderecoCidade == null ? other$enderecoCidade != null : !this$enderecoCidade.equals(other$enderecoCidade))
            return false;
        final Object this$enderecoEstado = this.getEnderecoEstado();
        final Object other$enderecoEstado = other.getEnderecoEstado();
        if (this$enderecoEstado == null ? other$enderecoEstado != null : !this$enderecoEstado.equals(other$enderecoEstado))
            return false;
        final Object this$enderecoCep = this.getEnderecoCep();
        final Object other$enderecoCep = other.getEnderecoCep();
        if (this$enderecoCep == null ? other$enderecoCep != null : !this$enderecoCep.equals(other$enderecoCep))
            return false;
        final Object this$role = this.getRole();
        final Object other$role = other.getRole();
        if (this$role == null ? other$role != null : !this$role.equals(other$role)) return false;
        if (this.isAtivo() != other.isAtivo()) return false;
        final Object this$carrinhos = this.getCarrinhos();
        final Object other$carrinhos = other.getCarrinhos();
        if (this$carrinhos == null ? other$carrinhos != null : !this$carrinhos.equals(other$carrinhos)) return false;
        final Object this$pedidos = this.getPedidos();
        final Object other$pedidos = other.getPedidos();
        if (this$pedidos == null ? other$pedidos != null : !this$pedidos.equals(other$pedidos)) return false;
        final Object this$produtos = this.getProdutos();
        final Object other$produtos = other.getProdutos();
        if (this$produtos == null ? other$produtos != null : !this$produtos.equals(other$produtos)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Usuario;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $nome = this.getNome();
        result = result * PRIME + ($nome == null ? 43 : $nome.hashCode());
        final Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        final Object $senha = this.getSenha();
        result = result * PRIME + ($senha == null ? 43 : $senha.hashCode());
        final Object $dataNascimento = this.getDataNascimento();
        result = result * PRIME + ($dataNascimento == null ? 43 : $dataNascimento.hashCode());
        final Object $enderecoRua = this.getEnderecoRua();
        result = result * PRIME + ($enderecoRua == null ? 43 : $enderecoRua.hashCode());
        final Object $enderecoNumero = this.getEnderecoNumero();
        result = result * PRIME + ($enderecoNumero == null ? 43 : $enderecoNumero.hashCode());
        final Object $enderecoBairro = this.getEnderecoBairro();
        result = result * PRIME + ($enderecoBairro == null ? 43 : $enderecoBairro.hashCode());
        final Object $enderecoCidade = this.getEnderecoCidade();
        result = result * PRIME + ($enderecoCidade == null ? 43 : $enderecoCidade.hashCode());
        final Object $enderecoEstado = this.getEnderecoEstado();
        result = result * PRIME + ($enderecoEstado == null ? 43 : $enderecoEstado.hashCode());
        final Object $enderecoCep = this.getEnderecoCep();
        result = result * PRIME + ($enderecoCep == null ? 43 : $enderecoCep.hashCode());
        final Object $role = this.getRole();
        result = result * PRIME + ($role == null ? 43 : $role.hashCode());
        result = result * PRIME + (this.isAtivo() ? 79 : 97);
        final Object $carrinhos = this.getCarrinhos();
        result = result * PRIME + ($carrinhos == null ? 43 : $carrinhos.hashCode());
        final Object $pedidos = this.getPedidos();
        result = result * PRIME + ($pedidos == null ? 43 : $pedidos.hashCode());
        final Object $produtos = this.getProdutos();
        result = result * PRIME + ($produtos == null ? 43 : $produtos.hashCode());
        return result;
    }

    public String toString() {
        return "Usuario(id=" + this.getId() + ", nome=" + this.getNome() + ", email=" + this.getEmail() + ", senha=" + this.getSenha() + ", dataNascimento=" + this.getDataNascimento() + ", enderecoRua=" + this.getEnderecoRua() + ", enderecoNumero=" + this.getEnderecoNumero() + ", enderecoBairro=" + this.getEnderecoBairro() + ", enderecoCidade=" + this.getEnderecoCidade() + ", enderecoEstado=" + this.getEnderecoEstado() + ", enderecoCep=" + this.getEnderecoCep() + ", role=" + this.getRole() + ", ativo=" + this.isAtivo() + ", carrinhos=" + this.getCarrinhos() + ", pedidos=" + this.getPedidos() + ", produtos=" + this.getProdutos() + ")";
    }

    public enum Role {
        ADMIN, CLIENTE, VENDEDOR
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + role.name()));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return ativo;
    }
}