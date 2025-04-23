package com.ecommerce.lojavirtual.dto;

import com.ecommerce.lojavirtual.model.Pedido;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
}