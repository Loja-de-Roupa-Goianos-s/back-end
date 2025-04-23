package com.ecommerce.lojavirtual.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemCarrinhoDTO {
    private Long id;

    @NotNull(message = "ID do produto é obrigatório")
    private Long produtoId;

    private String nomeProduto;

    @NotNull(message = "Quantidade é obrigatória")
    @Positive(message = "Quantidade deve ser maior que zero")
    private Integer quantidade;

    private BigDecimal precoUnitario;
    private BigDecimal subtotal;
}