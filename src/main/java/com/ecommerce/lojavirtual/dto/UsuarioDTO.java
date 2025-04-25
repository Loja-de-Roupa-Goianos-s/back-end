package com.ecommerce.lojavirtual.dto;

import com.ecommerce.lojavirtual.model.Usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class UsuarioDTO {
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email deve ser válido")
    private String email;

    @NotNull(message = "Data de nascimento é obrigatória")
    private LocalDate dataNascimento;

    private String enderecoRua;
    private String enderecoNumero;
    private String enderecoBairro;
    private String enderecoCidade;
    private String enderecoEstado;
    private String enderecoCep;
    private Usuario.Role role;
    private boolean ativo;

    public UsuarioDTO(Long id, @NotBlank(message = "Nome é obrigatório") String nome, @NotBlank(message = "Email é obrigatório") @Email(message = "Email deve ser válido") String email, @NotNull(message = "Data de nascimento é obrigatória") LocalDate dataNascimento, String enderecoRua, String enderecoNumero, String enderecoBairro, String enderecoCidade, String enderecoEstado, String enderecoCep, Usuario.Role role, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.enderecoRua = enderecoRua;
        this.enderecoNumero = enderecoNumero;
        this.enderecoBairro = enderecoBairro;
        this.enderecoCidade = enderecoCidade;
        this.enderecoEstado = enderecoEstado;
        this.enderecoCep = enderecoCep;
        this.role = role;
        this.ativo = ativo;
    }

    public UsuarioDTO() {
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

    public Usuario.Role getRole() {
        return this.role;
    }

    public boolean isAtivo() {
        return this.ativo;
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

    public void setRole(Usuario.Role role) {
        this.role = role;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof UsuarioDTO)) return false;
        final UsuarioDTO other = (UsuarioDTO) o;
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
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof UsuarioDTO;
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
        return result;
    }

    public String toString() {
        return "UsuarioDTO(id=" + this.getId() + ", nome=" + this.getNome() + ", email=" + this.getEmail() + ", dataNascimento=" + this.getDataNascimento() + ", enderecoRua=" + this.getEnderecoRua() + ", enderecoNumero=" + this.getEnderecoNumero() + ", enderecoBairro=" + this.getEnderecoBairro() + ", enderecoCidade=" + this.getEnderecoCidade() + ", enderecoEstado=" + this.getEnderecoEstado() + ", enderecoCep=" + this.getEnderecoCep() + ", role=" + this.getRole() + ", ativo=" + this.isAtivo() + ")";
    }
}