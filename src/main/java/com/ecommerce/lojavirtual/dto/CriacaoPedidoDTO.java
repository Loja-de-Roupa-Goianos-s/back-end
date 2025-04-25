package com.ecommerce.lojavirtual.dto;

import com.ecommerce.lojavirtual.model.Pedido;
import jakarta.validation.constraints.NotNull;

public class CriacaoPedidoDTO {

    @NotNull(message = "Forma de pagamento é obrigatória")
    private Pedido.FormaPagamento formaPagamento;

    private String enderecoEntregaRua;
    private String enderecoEntregaNumero;
    private String enderecoEntregaBairro;
    private String enderecoEntregaCidade;
    private String enderecoEntregaEstado;
    private String enderecoEntregaCep;

    // Se true, usa o endereço do usuário
    private boolean usarEnderecoUsuario = false;

    public CriacaoPedidoDTO(@NotNull(message = "Forma de pagamento é obrigatória") Pedido.FormaPagamento formaPagamento, String enderecoEntregaRua, String enderecoEntregaNumero, String enderecoEntregaBairro, String enderecoEntregaCidade, String enderecoEntregaEstado, String enderecoEntregaCep, boolean usarEnderecoUsuario) {
        this.formaPagamento = formaPagamento;
        this.enderecoEntregaRua = enderecoEntregaRua;
        this.enderecoEntregaNumero = enderecoEntregaNumero;
        this.enderecoEntregaBairro = enderecoEntregaBairro;
        this.enderecoEntregaCidade = enderecoEntregaCidade;
        this.enderecoEntregaEstado = enderecoEntregaEstado;
        this.enderecoEntregaCep = enderecoEntregaCep;
        this.usarEnderecoUsuario = usarEnderecoUsuario;
    }

    public CriacaoPedidoDTO() {
    }

    public Pedido.@NotNull(message = "Forma de pagamento é obrigatória") FormaPagamento getFormaPagamento() {
        return this.formaPagamento;
    }

    public String getEnderecoEntregaRua() {
        return this.enderecoEntregaRua;
    }

    public String getEnderecoEntregaNumero() {
        return this.enderecoEntregaNumero;
    }

    public String getEnderecoEntregaBairro() {
        return this.enderecoEntregaBairro;
    }

    public String getEnderecoEntregaCidade() {
        return this.enderecoEntregaCidade;
    }

    public String getEnderecoEntregaEstado() {
        return this.enderecoEntregaEstado;
    }

    public String getEnderecoEntregaCep() {
        return this.enderecoEntregaCep;
    }

    public boolean isUsarEnderecoUsuario() {
        return this.usarEnderecoUsuario;
    }

    public void setFormaPagamento(@NotNull(message = "Forma de pagamento é obrigatória") Pedido.FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public void setEnderecoEntregaRua(String enderecoEntregaRua) {
        this.enderecoEntregaRua = enderecoEntregaRua;
    }

    public void setEnderecoEntregaNumero(String enderecoEntregaNumero) {
        this.enderecoEntregaNumero = enderecoEntregaNumero;
    }

    public void setEnderecoEntregaBairro(String enderecoEntregaBairro) {
        this.enderecoEntregaBairro = enderecoEntregaBairro;
    }

    public void setEnderecoEntregaCidade(String enderecoEntregaCidade) {
        this.enderecoEntregaCidade = enderecoEntregaCidade;
    }

    public void setEnderecoEntregaEstado(String enderecoEntregaEstado) {
        this.enderecoEntregaEstado = enderecoEntregaEstado;
    }

    public void setEnderecoEntregaCep(String enderecoEntregaCep) {
        this.enderecoEntregaCep = enderecoEntregaCep;
    }

    public void setUsarEnderecoUsuario(boolean usarEnderecoUsuario) {
        this.usarEnderecoUsuario = usarEnderecoUsuario;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof CriacaoPedidoDTO)) return false;
        final CriacaoPedidoDTO other = (CriacaoPedidoDTO) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$formaPagamento = this.getFormaPagamento();
        final Object other$formaPagamento = other.getFormaPagamento();
        if (this$formaPagamento == null ? other$formaPagamento != null : !this$formaPagamento.equals(other$formaPagamento))
            return false;
        final Object this$enderecoEntregaRua = this.getEnderecoEntregaRua();
        final Object other$enderecoEntregaRua = other.getEnderecoEntregaRua();
        if (this$enderecoEntregaRua == null ? other$enderecoEntregaRua != null : !this$enderecoEntregaRua.equals(other$enderecoEntregaRua))
            return false;
        final Object this$enderecoEntregaNumero = this.getEnderecoEntregaNumero();
        final Object other$enderecoEntregaNumero = other.getEnderecoEntregaNumero();
        if (this$enderecoEntregaNumero == null ? other$enderecoEntregaNumero != null : !this$enderecoEntregaNumero.equals(other$enderecoEntregaNumero))
            return false;
        final Object this$enderecoEntregaBairro = this.getEnderecoEntregaBairro();
        final Object other$enderecoEntregaBairro = other.getEnderecoEntregaBairro();
        if (this$enderecoEntregaBairro == null ? other$enderecoEntregaBairro != null : !this$enderecoEntregaBairro.equals(other$enderecoEntregaBairro))
            return false;
        final Object this$enderecoEntregaCidade = this.getEnderecoEntregaCidade();
        final Object other$enderecoEntregaCidade = other.getEnderecoEntregaCidade();
        if (this$enderecoEntregaCidade == null ? other$enderecoEntregaCidade != null : !this$enderecoEntregaCidade.equals(other$enderecoEntregaCidade))
            return false;
        final Object this$enderecoEntregaEstado = this.getEnderecoEntregaEstado();
        final Object other$enderecoEntregaEstado = other.getEnderecoEntregaEstado();
        if (this$enderecoEntregaEstado == null ? other$enderecoEntregaEstado != null : !this$enderecoEntregaEstado.equals(other$enderecoEntregaEstado))
            return false;
        final Object this$enderecoEntregaCep = this.getEnderecoEntregaCep();
        final Object other$enderecoEntregaCep = other.getEnderecoEntregaCep();
        if (this$enderecoEntregaCep == null ? other$enderecoEntregaCep != null : !this$enderecoEntregaCep.equals(other$enderecoEntregaCep))
            return false;
        if (this.isUsarEnderecoUsuario() != other.isUsarEnderecoUsuario()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CriacaoPedidoDTO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $formaPagamento = this.getFormaPagamento();
        result = result * PRIME + ($formaPagamento == null ? 43 : $formaPagamento.hashCode());
        final Object $enderecoEntregaRua = this.getEnderecoEntregaRua();
        result = result * PRIME + ($enderecoEntregaRua == null ? 43 : $enderecoEntregaRua.hashCode());
        final Object $enderecoEntregaNumero = this.getEnderecoEntregaNumero();
        result = result * PRIME + ($enderecoEntregaNumero == null ? 43 : $enderecoEntregaNumero.hashCode());
        final Object $enderecoEntregaBairro = this.getEnderecoEntregaBairro();
        result = result * PRIME + ($enderecoEntregaBairro == null ? 43 : $enderecoEntregaBairro.hashCode());
        final Object $enderecoEntregaCidade = this.getEnderecoEntregaCidade();
        result = result * PRIME + ($enderecoEntregaCidade == null ? 43 : $enderecoEntregaCidade.hashCode());
        final Object $enderecoEntregaEstado = this.getEnderecoEntregaEstado();
        result = result * PRIME + ($enderecoEntregaEstado == null ? 43 : $enderecoEntregaEstado.hashCode());
        final Object $enderecoEntregaCep = this.getEnderecoEntregaCep();
        result = result * PRIME + ($enderecoEntregaCep == null ? 43 : $enderecoEntregaCep.hashCode());
        result = result * PRIME + (this.isUsarEnderecoUsuario() ? 79 : 97);
        return result;
    }

    public String toString() {
        return "CriacaoPedidoDTO(formaPagamento=" + this.getFormaPagamento() + ", enderecoEntregaRua=" + this.getEnderecoEntregaRua() + ", enderecoEntregaNumero=" + this.getEnderecoEntregaNumero() + ", enderecoEntregaBairro=" + this.getEnderecoEntregaBairro() + ", enderecoEntregaCidade=" + this.getEnderecoEntregaCidade() + ", enderecoEntregaEstado=" + this.getEnderecoEntregaEstado() + ", enderecoEntregaCep=" + this.getEnderecoEntregaCep() + ", usarEnderecoUsuario=" + this.isUsarEnderecoUsuario() + ")";
    }
}