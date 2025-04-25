package com.ecommerce.lojavirtual.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class LoginDTO {

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email deve ser válido")
    private String email;

    @NotBlank(message = "Senha é obrigatória")
    private String senha;

    public LoginDTO(@NotBlank(message = "Email é obrigatório") @Email(message = "Email deve ser válido") String email, @NotBlank(message = "Senha é obrigatória") String senha) {
        this.email = email;
        this.senha = senha;
    }

    public LoginDTO() {
    }

    public @NotBlank(message = "Email é obrigatório") @Email(message = "Email deve ser válido") String getEmail() {
        return this.email;
    }

    public @NotBlank(message = "Senha é obrigatória") String getSenha() {
        return this.senha;
    }

    public void setEmail(@NotBlank(message = "Email é obrigatório") @Email(message = "Email deve ser válido") String email) {
        this.email = email;
    }

    public void setSenha(@NotBlank(message = "Senha é obrigatória") String senha) {
        this.senha = senha;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof LoginDTO)) return false;
        final LoginDTO other = (LoginDTO) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$email = this.getEmail();
        final Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
        final Object this$senha = this.getSenha();
        final Object other$senha = other.getSenha();
        if (this$senha == null ? other$senha != null : !this$senha.equals(other$senha)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof LoginDTO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        final Object $senha = this.getSenha();
        result = result * PRIME + ($senha == null ? 43 : $senha.hashCode());
        return result;
    }

    public String toString() {
        return "LoginDTO(email=" + this.getEmail() + ", senha=" + this.getSenha() + ")";
    }
}